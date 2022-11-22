package com.java.CSC300;
import java.util.ArrayList;

public class StackMin {
	
	private ArrayList<Integer> stack = new ArrayList<Integer>();
	private int min = -1;
	private int minprev = -1;

	public StackMin(int val) {
		this.stack.add(val);
		this.min = val;
	}
	
	//////////////////////////////////////////
	
	public String toString() {
		return this.stack.toString();
	}
	
	public int peek() {
		return this.stack.get(0);
	}
	
	public boolean pop() {
		if(this.stack.size() != 0) {
			this.peek();
			if(this.stack.get(0) == this.min) {
				this.min = this.minprev;
			}
			this.stack.remove(0);
			return true;
		}
		return false;
	}
	
	public void push(int val) {
		this.stack.add(0, val);
		if(val < this.min) {
			this.minprev = this.min;
			this.min = val;
		}
	}
	
	public int min() {
		return this.min;
	}
}
