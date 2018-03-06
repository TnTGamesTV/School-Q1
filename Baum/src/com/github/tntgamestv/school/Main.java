/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.regex.Pattern;

/**
 * @author TnTGamesTV Project: B�ume Date: 20-02-2018
 */
public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Informatiker> tree = new BinarySearchTree<>();
		InformatikerSupplier supplier = new InformatikerSupplier();

		tree.insert(supplier.get());
		tree.insert(supplier.get());
		tree.insert(supplier.get());
		tree.insert(supplier.get());
		tree.insert(supplier.get());
		tree.insert(supplier.get());

		GraphicalTreeWrapper<Informatiker> wrapper = new GraphicalTreeWrapper<>(tree);

		wrapper.display();

		// tree.delete(i2);

		// tree.inorder(tree, new ITraverse<Informatiker>() {
		//
		// @Override
		// public boolean traverse(BinarySearchTree<Informatiker> tree) {
		// System.out.println(tree.getContent().getName() + ": " +
		// tree.getContent().getDay() + "."
		// + tree.getContent().getMonth() + "." + tree.getContent().getYear());
		// return false;
		// }
		// });

		System.out.println(tree.inorderDebug());
	}

	/**
	 * Old method for performing actions on tree filled with morse code
	 * 
	 * @param args
	 */
	public static void main2(String[] args) {
		MorseTree binTree = new MorseTree();
		binTree.setContent("");

		BinarySearchTree<String> e = new BinarySearchTree<String>("E");
		BinarySearchTree<String> t = new BinarySearchTree<String>("T");
		binTree.setLeftTree(e);
		binTree.setRightTree(t);

		BinarySearchTree<String> i = new BinarySearchTree<String>("I");
		BinarySearchTree<String> a = new BinarySearchTree<String>("A");
		BinarySearchTree<String> n = new BinarySearchTree<String>("N");
		BinarySearchTree<String> m = new BinarySearchTree<String>("M");
		e.setLeftTree(i);
		e.setRightTree(a);
		t.setLeftTree(n);
		t.setRightTree(m);

		BinarySearchTree<String> s = new BinarySearchTree<String>("S");
		BinarySearchTree<String> u = new BinarySearchTree<String>("U");
		BinarySearchTree<String> r = new BinarySearchTree<String>("R");
		BinarySearchTree<String> w = new BinarySearchTree<String>("W");
		BinarySearchTree<String> d = new BinarySearchTree<String>("D");
		BinarySearchTree<String> k = new BinarySearchTree<String>("K");
		BinarySearchTree<String> g = new BinarySearchTree<String>("Q");
		BinarySearchTree<String> o = new BinarySearchTree<String>("O");
		i.setLeftTree(s);
		i.setRightTree(u);
		a.setLeftTree(r);
		a.setRightTree(w);
		n.setLeftTree(d);
		n.setRightTree(k);
		m.setLeftTree(g);
		m.setRightTree(o);

		BinarySearchTree<String> h = new BinarySearchTree<String>("H");
		BinarySearchTree<String> v = new BinarySearchTree<String>("V");
		BinarySearchTree<String> f = new BinarySearchTree<String>("F");
		BinarySearchTree<String> � = new BinarySearchTree<String>("�");
		BinarySearchTree<String> l = new BinarySearchTree<String>("L");
		BinarySearchTree<String> � = new BinarySearchTree<String>("�");
		BinarySearchTree<String> p = new BinarySearchTree<String>("P");
		BinarySearchTree<String> j = new BinarySearchTree<String>("J");
		BinarySearchTree<String> b = new BinarySearchTree<String>("B");
		BinarySearchTree<String> x = new BinarySearchTree<String>("X");
		BinarySearchTree<String> c = new BinarySearchTree<String>("C");
		BinarySearchTree<String> y = new BinarySearchTree<String>("Y");
		BinarySearchTree<String> q = new BinarySearchTree<String>("Q");
		BinarySearchTree<String> z = new BinarySearchTree<String>("Z");
		BinarySearchTree<String> � = new BinarySearchTree<String>("�");
		BinarySearchTree<String> ch = new BinarySearchTree<String>("CH");
		s.setLeftTree(h);
		s.setRightTree(v);
		u.setLeftTree(f);
		u.setRightTree(�);
		r.setLeftTree(l);
		r.setRightTree(�);
		w.setLeftTree(p);
		w.setRightTree(j);
		d.setLeftTree(b);
		d.setRightTree(x);
		k.setLeftTree(c);
		k.setRightTree(y);
		g.setLeftTree(q);
		g.setRightTree(z);
		o.setLeftTree(�);
		o.setRightTree(ch);

		String sentence = "SAYAN IST DOOF";

		Pattern.compile(" ").splitAsStream(sentence).forEachOrdered((word) ->
		{
			word.chars().forEachOrdered((letter) ->
			{
				binTree.findTypes(Character.toString((char) letter)).stream().forEachOrdered((morseTreeType) ->
				{
					System.out.print(morseTreeType.symbol);
				});
				System.out.println();
			});
			System.out.println();
		});
	}
}