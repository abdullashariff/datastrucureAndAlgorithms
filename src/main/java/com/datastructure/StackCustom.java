package com.datastructure;

import java.lang.reflect.Array;

class Stack<T> {
	static final int MAX = 1000;
	int top;
	T arr[]; // Maximum size of Stack

	boolean isEmpty() {
		return (top < 0);
	}

	Stack(Class<T> clazz,int capacity) {
		top = -1;
		arr = (T[])Array.newInstance(clazz, capacity);
	}

	boolean push(T x) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			arr[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	T pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			T x = arr[top--];
			return x;
		}
	}

	T peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			T x = arr[top];
			return x;
		}
	}
}

// Driver code 
public class StackCustom {
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>(Integer.class,10);
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
	}
}
