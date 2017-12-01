/**
 * 
 */
package com.github.tntgamestv.school.rangierbahnhof;

import com.github.tntgamestv.school.Stack;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 01-12-2017
 */
public class Gleis {

	public static final int ROLE_UNDEFINED = -1;
	public static final int ROLE_START = 1;
	public static final int ROLE_CACHE = 2;
	public static final int ROLE_END = 3;
	
	private String id;
	private int role = ROLE_UNDEFINED;
	
	private Stack<Wagon> content;
	
	public Gleis(String id, int role) {
		this.id = id;
		this.role = role;
		
		this.content = new Stack<>();
	}
	
	public Wagon pop() {
		return this.content.pop();
	}
	
	public Wagon top() {
		return this.content.top();
	}
	
	public boolean isEmpty() {
		return this.content.isEmpty();
	}
	
	public void push(Wagon content) {
		this.content.push(content);
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
	/**
	 * @return the content
	 */
	public Stack<Wagon> getContent() {
		return content;
	}
}
