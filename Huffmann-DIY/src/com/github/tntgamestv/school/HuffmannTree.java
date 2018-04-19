package com.github.tntgamestv.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import graphical.GraphicalTreeWrapper;
import graphical.IGraphicalTreeNodeNamer;

/**
 * @author Finn Tegeler
 */
public class HuffmannTree extends BinaryTree<BinaryTree<Data>> {

	public interface HuffmannCharacaterMappingConsumer {

		void consume(String character, List<Signal> signals);
	}

	public class HuffmannMapping {

		private HashMap<String, List<Signal>> mapping;

		public HuffmannMapping(HashMap<String, List<Signal>> mapping) {
			this.mapping = mapping;
		}

		/**
		 * @return the mapping
		 */
		public HashMap<String, List<Signal>> getMapping() {
			return mapping;
		}

		public void forEachOrdered(HuffmannCharacaterMappingConsumer consumer) {
			mapping.entrySet().stream().forEachOrdered((entry) ->
			{
				consumer.consume(entry.getKey(), entry.getValue());
			});
		}
	}

	/* Input */
	private String						input;

	/* State & Logging */
	private List<Integer>				correctStates	= Stream.of(-1, 0, 1, 2, 3).collect(Collectors.toList());

	private int							state;
	private boolean						thrown;

	/* Node mapping and managment */
	private List<BinaryTree<Data>>		nodeManagment;
	private HashMap<String, Integer>	nodeCharacterAmountMapping;
	private BinaryTree<Data>			resultRootNode;

	/* Listener */
	private IPropertyChangeListener		propertyChangeListener;

	/**
	 * Initalize variables
	 */
	{
		thrown = false;
		state = 0;
	}

	public HuffmannTree() {}

	public HuffmannTree(String input) {
		this.input = input;

		this._initialize();
	}

	public void insertInput(String input) {
		this.input = input;

		this._initialize();
	}

	/**
	 * Create objects and start prepartion phase
	 */
	private void _initialize() {
		input = input.toUpperCase(); // Only upper letters

		// New data structures
		nodeManagment = new ArrayList<>();
		nodeCharacterAmountMapping = new HashMap<>();

		// State 1 => Preparing data
		this._setState(1);
		this._prepare();
	}

	/**
	 * Slice input into chars and map their amount to them
	 */
	private void _prepare() {

		// Map input to individual chars with amount
		input.chars().filter(Character::isAlphabetic).mapToObj(ch -> (char) ch).forEachOrdered((c) ->
		{
			// If char has already been mapped
			if (nodeCharacterAmountMapping.containsKey(c.toString())) {
				nodeCharacterAmountMapping.put(c.toString(), nodeCharacterAmountMapping.get(c.toString()) + 1);
				// Map new amount
			} else {
				// Map char to amount of 1
				nodeCharacterAmountMapping.put(c.toString(), 1);
			}
		});

		// Create data sets and add them to list (inside of a binary tree)
		nodeCharacterAmountMapping.entrySet().stream().forEachOrdered((entry) ->
		{
			// New data set
			Data data = new Data(entry.getValue(), entry.getKey());

			// Create new tree and add it to managment list
			nodeManagment.add(new BinaryTree<Data>(data));
		});

		// State 2 => Sorting
		this._setState(2);
	}

	/**
	 * Start sorting
	 * 
	 * @return boolean true if execution was completed with success
	 */
	public boolean start() {
		if (state == 3) {
			// If tree has already been sorted: skip sorting
			return true;
		} else if (state < 2) {
			// If tree is not prepared throw exception
			this._throwException(
					"Wrong state for starting (Current state is " + state + "). Something went wrong befor this!");
			return false;
		} else {
			// While there are more then one root node
			while (nodeManagment.size() > 1) {

				// Find the first minimun
				nodeManagment.stream().min(new Data.DataComperator()).ifPresent((min1) ->
				{
					nodeManagment.remove(min1); // Remove from list

					// Find second minimun (it will be selected because first
					// minimun is removed)
					nodeManagment.stream().min(new Data.DataComperator()).ifPresent((min2) ->
					{
						nodeManagment.remove(min2); // Remove second minimum
													// from list

						// Calculate total amount and create new parent node
						int totalAmount = min1.getContent().getAmount() + min2.getContent().getAmount();
						BinaryTree<Data> parentTree = new BinaryTree<>(
								new Data(totalAmount, min1.getContent().getContent() + min2.getContent().getContent()));
						parentTree.setLeftTree(min1);
						parentTree.setRightTree(min2);

						// Add new parent node to list
						nodeManagment.add(parentTree);
					});
				});
			}

			// Link result node
			resultRootNode = nodeManagment.get(0);

			// State 3 => Finished
			this._setState(3);
			return true;
		}
	}

	public BinaryTree<Data> getContent() {
		return this.resultRootNode;
	}

	public void display() {
		if (state == 3) {
			// If tree has been sorted create a new GraphicalTreeWrapper
			GraphicalTreeWrapper<Data> wrapper = new GraphicalTreeWrapper<Data>(resultRootNode,
					new IGraphicalTreeNodeNamer<Data>() {

						@Override
						public String getNodeName(BinaryTree<Data> b) {
							return b.getContent().getContent() + ": " + b.getContent().getAmount();
						}
					});
			wrapper.display();
		}
	}

	private List<Signal> _getResultForChar(String s) {
		List<Signal> result = new ArrayList<>();

		this._getResultForChar(resultRootNode, result, new ArrayList<>(), s);

		return result;
	}

	private void _getResultForChar(BinaryTree<Data> tree, List<Signal> result, List<Signal> tmp, String s) {
		if (tree.getContent().getContent().equals(s)) {
			result.addAll(tmp);
			return;
		}

		if (tree.getLeftTree() != null && tree.getLeftTree().getContent() != null) {
			tmp.add(Signal.SHORT);
			this._getResultForChar(tree.getLeftTree(), result, tmp, s);
		}

		if (tree.getRightTree() != null && tree.getRightTree().getContent() != null) {
			tmp.add(Signal.LONG);
			this._getResultForChar(tree.getRightTree(), result, tmp, s);
		}

		tmp.remove(tmp.size() - 1);
	}

	/**
	 * Returns the code for each char mapped to the char itself
	 * 
	 * @return
	 */
	public HashMap<String, List<Signal>> returnResultMappedToChars() {
		HashMap<String, List<Signal>> mapping = new HashMap<>();

		nodeCharacterAmountMapping.entrySet().stream().forEach((entry) ->
		{
			List<Signal> signals = _getResultForChar(entry.getKey());

			mapping.put(entry.getKey(), signals);
		});

		return mapping;
	}

	private void _setState(int newState) {
		if (correctStates.stream().anyMatch((correctState) -> correctState == newState)) {
			if (propertyChangeListener != null) propertyChangeListener.properyChanged(this, newState);
			this.state = newState;
		} else {
			this._throwException("Given newState is not a correct state");
		}
	}

	private void _throwException(String s) {
		_setState(-1);
		thrown = true;

		throw new HuffmannTreeException(s);
	}
}
