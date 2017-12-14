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
		
	}
	
	public String execute(String input) {
		Stack<String> stack = new Stack<>();
		String output = "";
		
		stack.push("(");
		input += ")";
		
		char current = input.charAt(0);
		int i = 1;
		while(!stack.isEmpty() && i < input.length()) {
			
			if((current + "").matches("[0-9]")) {
				output += "" + current;
			}else if((current + "").equals("(")) {
				stack.push("" + current);
			}else if((current + "").matches("+-/*")) {
				while(!stack.isEmpty() 
						&& stack.top().matches("+-/*") //Wenn es ein Operator ist 
						&& ((current + "").matches("/*") && stack.top().matches("/*") 
								|| (current + "").matches("+-") && stack.top().matches("+-") 
								||(current + "").matches("+-") && stack.top().matches("/*"))
						) {
					String popped = stack.pop();
					
					output += popped;
				}
				
				stack.push("" + current);
			}
			
			i++;
			current = input.charAt(0);
		}
		
		return output;
	}
}
