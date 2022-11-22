package com.java.CSC300;

public class Driver {
	public static void main(String[] args) {
		StackMin stackmin = new StackMin(6);
		stackmin.push(4);
		System.out.println(stackmin.toString());
		stackmin.push(7);
		System.out.println(stackmin.toString());
		System.out.println(stackmin.peek());
		System.out.println(stackmin.min());
		
		stackmin.pop();
		System.out.println(stackmin.toString());
		stackmin.push(3);
		System.out.println(stackmin.toString());
		System.out.println(stackmin.min());
		stackmin.pop();
		System.out.println(stackmin.toString());
		stackmin.pop();
		stackmin.pop();
		stackmin.pop();
		System.out.println(stackmin.toString());
	}
}
