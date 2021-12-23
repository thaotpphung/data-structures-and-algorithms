package stack.linkedListStack;

import linkedlist_queue.Node;

/*
 * This class implements the logic of a stack using CustomLinkedList
 * @author Thao Phung
 * September 7 2018
 * 
 * Thao Phung
 */
public class LinkedListStack {

	private Node top;
	private int sSize;

	/**
	 * Constructor to construct a LinkedList and a stack implements that LinkedList
	 */
	public LinkedListStack() {
		sSize = 0;
		top = null;
	}

	/**
	 * Method to push datq into the stack
	 * 
	 * @param data
	 *             to be pushed
	 */
	public void push(int data) {
		Node node = new Node(data, null);
		if (top == null)
			top = node;
		else {
			node.setNext(top);
			top = node;
		}
		sSize++;
		System.out.println("\nOperation push -");
		display();
	}

	/**
	 * Method to pop data out of the stack
	 */
	public void pop() {
		try {
			top = top.getNext();
			System.out.println("\nOperation pop -");
			display();
			sSize--;
		} catch (NullPointerException e) {
			System.out.println("Stack is empty");
			return;
		}

	}

	/**
	 * Method to get the size of the stack
	 * 
	 * @return the size of the stack
	 */
	public int getSize() {
		if (top == null) {
			System.out.println("Stack is empty");
			return -1;
		}
		return sSize;
	}

	/**
	 * Method to display the elements in the stacks
	 */
	public void display() {
		System.out.print("Stack = ");
		if (top == null) {
			System.out.print("empty\n");
			return;
		}
		Node aNode = top;
		System.out.print(" " + aNode.getData());
		aNode = aNode.getNext();
		while (aNode != null) {
			System.out.print(" <- " + aNode.getData());
			aNode = aNode.getNext();
		}
		System.out.println("\n");

	}

}
