/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.regex.Pattern;

/**
 * @author TnTGamesTV Project: Bäume Date: 20-02-2018
 */
public class Main {

	public static void main(String[] args) {
		MorseTree binTree = new MorseTree();
		binTree.setContent("");

		BinaryTree<String> e = new BinaryTree<String>("E");
		BinaryTree<String> t = new BinaryTree<String>("T");
		binTree.setLeftTree(e);
		binTree.setRightTree(t);

		BinaryTree<String> i = new BinaryTree<String>("I");
		BinaryTree<String> a = new BinaryTree<String>("A");
		BinaryTree<String> n = new BinaryTree<String>("N");
		BinaryTree<String> m = new BinaryTree<String>("M");
		e.setLeftTree(i);
		e.setRightTree(a);
		t.setLeftTree(n);
		t.setRightTree(m);

		BinaryTree<String> s = new BinaryTree<String>("S");
		BinaryTree<String> u = new BinaryTree<String>("U");
		BinaryTree<String> r = new BinaryTree<String>("R");
		BinaryTree<String> w = new BinaryTree<String>("W");
		BinaryTree<String> d = new BinaryTree<String>("D");
		BinaryTree<String> k = new BinaryTree<String>("K");
		BinaryTree<String> g = new BinaryTree<String>("Q");
		BinaryTree<String> o = new BinaryTree<String>("O");
		i.setLeftTree(s);
		i.setRightTree(u);
		a.setLeftTree(r);
		a.setRightTree(w);
		n.setLeftTree(d);
		n.setRightTree(k);
		m.setLeftTree(g);
		m.setRightTree(o);

		BinaryTree<String> h = new BinaryTree<String>("H");
		BinaryTree<String> v = new BinaryTree<String>("V");
		BinaryTree<String> f = new BinaryTree<String>("F");
		BinaryTree<String> ü = new BinaryTree<String>("Ü");
		BinaryTree<String> l = new BinaryTree<String>("L");
		BinaryTree<String> ä = new BinaryTree<String>("Ä");
		BinaryTree<String> p = new BinaryTree<String>("P");
		BinaryTree<String> j = new BinaryTree<String>("J");
		BinaryTree<String> b = new BinaryTree<String>("B");
		BinaryTree<String> x = new BinaryTree<String>("X");
		BinaryTree<String> c = new BinaryTree<String>("C");
		BinaryTree<String> y = new BinaryTree<String>("Y");
		BinaryTree<String> q = new BinaryTree<String>("Q");
		BinaryTree<String> z = new BinaryTree<String>("Z");
		BinaryTree<String> ö = new BinaryTree<String>("Ö");
		BinaryTree<String> ch = new BinaryTree<String>("CH");
		s.setLeftTree(h);
		s.setRightTree(v);
		u.setLeftTree(f);
		u.setRightTree(ü);
		r.setLeftTree(l);
		r.setRightTree(ä);
		w.setLeftTree(p);
		w.setRightTree(j);
		d.setLeftTree(b);
		d.setRightTree(x);
		k.setLeftTree(c);
		k.setRightTree(y);
		g.setLeftTree(q);
		g.setRightTree(z);
		o.setLeftTree(ö);
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