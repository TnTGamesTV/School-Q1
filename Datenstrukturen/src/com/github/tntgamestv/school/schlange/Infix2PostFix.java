/**
 * 
 */
package com.github.tntgamestv.school.schlange;

import com.github.tntgamestv.school.Stack;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 14-12-2017
 */
public class Infix2PostFix {

	public static void main(String[] args) {
		String input = "3+(3+5)*(7-3)/2)";
		
		System.out.println("Output: " + execute2(input));
	}
	
	public static int p(String current) {
		if(current.equals("+") || current.equals("-")) {
			return 1;
		}else if(current.equals("/") || current.equals("*")) {
			return 2;
		}
		
		return -1;
	}
	
	public static String execute3(String input) {
		String output = "";
		Stack<String> stack = new Stack<>();
		
		String[] chars = new StringBuilder(input).reverse().toString().split("");
		
		Stack<String> in = new Stack<>();
		for(String s : chars) in.push(s);
		
		while(!in.isEmpty()) {
			String s = in.pop();
		}
		
		return output;
	}
	
	public static String execute2(String input) {
		String output = "";
		Stack<String> stack = new Stack<>();
		Stack<String> sndStack = new Stack<>();
		
		String[] chars = new StringBuilder(input).reverse().toString().split("");
		
		Stack<String> in = new Stack<>();
		for(String s : chars) in.push(s);
		
		while(!in.isEmpty()) {
			String s = in.pop();
			
			if(s.matches("\\d")) {
				output += s;
				
				if(!in.top().matches("\\d") && !stack.isEmpty() && stack.top().matches("\\+|\\-|\\*|\\/")) {
					output += stack.pop();
				}
			}else if(s.matches("\\+|\\-|\\*|\\/")) {
				//Operator
				
				stack.push(s);
			}
		}
		
		return output;
	}
	
	public static String execute(String input) {
		Stack<String> stack = new Stack<>();
		String output = "";
		
		stack.push("(");
		input += ")";

		String current = input.substring(0, 1);
		
		int i = 1;
		while(!stack.isEmpty() && i < input.length() ) {
			
			if(current.matches("\\d")) {
				output += current;
			}else if(current.equals("(")) {
				stack.push(current);
			}else if(current.matches("\\+|\\-|\\/|\\*")) {
				while(!stack.isEmpty() 
						&& stack.top().matches("\\+|\\-|\\/|\\*") //Wenn es ein Operator ist 
						&& p(stack.top()) >= p(current)) {
					String popped = stack.pop();
					
					output += popped;
				}
				
				stack.push(current);
			}else if(current.equals(")")) {
				while(stack.top().matches("\\+\\-\\*\\/") && !stack.top().equals("(") ) {
					output += stack.pop();
				}
				
				if(stack.top().equals("(")) {
					stack.pop();
				}
			}
			
			current = input.substring(i, i + 1);
			i++;
		}
		
		return output;
	}
}
