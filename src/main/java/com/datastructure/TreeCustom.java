package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class TreeCustom {

	private Node root;

	private class Node {

		int value;
		Node left;
		Node right;

		// Constructor
		Node(int d) {
			value = d;
			left = null;
			right = null;
		}
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private void createBinaryTree() {
		add(6);
		add(4);
		add(8);
		add(3);
		add(5);
		add(7);
		add(9);
	}

	// Search
	// 1.Depath first
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.value);
	        traverseInOrder(node.right);
	    }
	}
	
	public void traversePreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.value);
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	
	public void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.print(" " + node.value);
	    }
	}

	//case: BFS:(breath first search)
	
	public void traverseLevelSearch(Node root) {

		if (root == null) {
	        return;
	    }
		
		Queue<Node> tempNodes = new LinkedList<Node>();
		tempNodes.add(root);
		
		while(root != null ) {
			Node node = tempNodes.remove();
			
			System.out.println(node.value);
			
			if(node.left != null ) {
				tempNodes.add(node.left);
			}
			
			if(node.right != null ) {
				tempNodes.add(node.right);
			}
		}
		
		
	}

	public static void main(String[] args) {
		TreeCustom bt = new TreeCustom();
		bt.createBinaryTree();

		System.out.println(bt.containsNode(6));
		System.out.println(bt.containsNode(4));

		Node temp = bt.root;
		
		bt.traverseLevelSearch(temp);
	}
}
