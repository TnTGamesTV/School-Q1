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
		input = input.toUpperCase();

		nodeManagment = new ArrayList<>();
		nodeCharacterAmountMapping = new HashMap<>();

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
			if (nodeCharacterAmountMapping.containsKey(c.toString())) {
				nodeCharacterAmountMapping.put(c.toString(), nodeCharacterAmountMapping.get(c.toString()) + 1);
			} else {
				nodeCharacterAmountMapping.put(c.toString(), 1);
			}
		});

		// Create data sets and add them to list (inside of a binary tree)
		nodeCharacterAmountMapping.entrySet().stream().forEachOrdered((entry) ->
		{
			Data data = new Data(entry.getValue(), entry.getKey());

			nodeManagment.add(new BinaryTree<Data>(data));
		});

		this._setState(2);
	}

	/**
	 * Start sorting
	 * 
	 * @return boolean true if execution was completed with success
	 */
	public boolean start() {
		if (state == 3) {
			return true;
		} else if (state < 2) {
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

			resultRootNode = nodeManagment.get(0);

			this._setState(3);
			return true;
		}
	}

	public BinaryTree<Data> getContent() {
		return this.resultRootNode;
	}

	public void display() {
		if (state == 3) {
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

	/**
	 * Returns the code for each char mapped to the char itself
	 * 
	 * @return
	 */
	public HashMap<Character, List<Signal>> returnResultMappedToChars() {
		HashMap<Character, List<Signal>> mapping = new HashMap<>();

		_getResultMappedToChars(this.resultRootNode, mapping, new ArrayList<>());

		return mapping;
	}

	private void _getResultMappedToChars(BinaryTree<Data> b, HashMap<Character, List<Signal>> mapping,
			List<Signal> currentSignals) {
		if (!b.isEmpty()) {
			if (b.getLeftTree() != null) {
				// Add all current chars to mapping
				currentSignals.add(Signal.SHORT);

				_getResultMappedToChars(b.getLeftTree(), mapping, currentSignals);
			}

			if (b.getContent().getContent().length() == 1) {
				mapping.put(b.getContent().getContent().charAt(0), currentSignals);
			}

			if (b.getRightTree() != null) {
				// Add all current chars to mapping
				currentSignals.add(Signal.LONG);

				_getResultMappedToChars(b.getRightTree(), mapping, currentSignals);
			}
		}
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
