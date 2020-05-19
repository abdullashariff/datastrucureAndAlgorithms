package com.datastructure;

class MyLinkedList<T> {
	private Node head; // head of list
	private MyLinkedList<T> list ;

	// Linked list Node.
	// This inner class is made static
	// so that main() can access it
	private class Node {

		T data;
		Node next;

		// Constructor
		Node(T d) {
			data = d;
			next = null;
		}
	}

	// Method to insert a new node
	public void insert(T i) {
		// Create a new node with given data
		Node new_node = new Node(i);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (null == list || null == list.head) {
			list = new MyLinkedList<T>();
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

	}

	// Method to print the LinkedList.
	public void printList() {
		
		if (null == list) return;
		
		Node currNode = list.head;
		System.out.print("LinkedList: ");
		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");
			// Go to next node
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	// Method to delete a node in the LinkedList by POSITION 
    public void deleteAtPosition(T key) 
    { 
        // Store head node 
        Node currNode = list.head, prev = null; 
   
        // CASE 1: 
        // If head node itself holds the key to be deleted 
  
        if (currNode != null && currNode.data == key) { 
            list.head = currNode.next; // Changed head 
  
            // Display the message 
            System.out.println(key + " found and deleted"); 
  
        } 
        
        // CASE 2: 
        // If the key is somewhere other than at head 
        // 
  
        // Search for the key to be deleted, 
        // keep track of the previous node 
        // as it is needed to change currNode.next 
        while (currNode != null && currNode.data != key) { 
            // If currNode does not hold key 
            // continue to next node 
            prev = currNode; 
            currNode = currNode.next; 
        } 
  
        // If the key was present, it should be at currNode 
        // Therefore the currNode shall not be null 
        if (currNode != null) { 
            // Since the key is at currNode 
            // Unlink currNode from linked list 
            prev.next = currNode.next; 
  
            // Display the message 
            System.out.println(key + " found and deleted"); 
        } 
  
        // 
        // CASE 3: The key is not present 
        // 
  
        // If key was not present in linked list 
        // currNode should be null 
        if (currNode == null) { 
            // Display the message 
            System.out.println(key + " not found"); 
        } 
        
    }

}

public class LinkedListCustom {
	// Driver code
	public static void main(String[] args) {
		/* Start with the empty list. */
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		//
		// ******INSERTION******
		//

		// Insert the values
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);

		// Print the LinkedList
		list.printList();
		
		list.deleteAtPosition(8);
		
		list.printList();
	}
}