package linkedList.singlyLinkedList;

import java.util.Arrays;

import linkedlist_queue.Node;

/*
 * This class implements a Singly or One way linked list
 * The standard options for linked list operations are also implemented (like insert a node or deleting a node)
 * @author Thao Phung
 * August 23 2018
 */
public class SinglyLinkedList {
	private Node start;
	private Node end;
	private int size;

	/* Constructor */
	public SinglyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	/**
	 * Function to check if list is empty
	 * 
	 * @return true: if the list is empty, false: otherwise
	 */
	public boolean isEmpty() {
		if (start == null)
			return true;
		else
			return false;
	}

	/**
	 * Function to get size of list
	 * 
	 * @return size of the list (# of nodes)
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Function to insert an element at beginning
	 * 
	 * @param val
	 *            value to be inserted at the first node of the list
	 */
	public void insertAtStart(int val) {
		Node node = new Node(val, null);
		size++;
		if (start == null) {
			start = node;
			end = start;
		} else {
			node.setNext(start);
			start = node;
		}
	}

	/**
	 * Function to insert an element at end
	 * 
	 * @param val
	 *            value to be inserted at the last node of the list
	 */
	public void insertAtEnd(int val) {
		Node node = new Node(val, null);
		size++;
		if (start == null) {
			start = node;
			end = start;
		} else {
			end.setNext(node);
			end = node;
		}
	}

	/**
	 * Function to insert an element at position
	 * 
	 * @param val
	 *            value to be inserted in the list
	 * @param pos
	 *            position of the value in the list
	 */
	public void insertAtPos(int val, int pos) {
		// write code here to make it safe method call
		// should print error msg if user tries to insert at the start
		// or at the end. Should return after printing the msg

		Node node = new Node(val, null);
		Node aNode = start;
		if (pos == 1) {
			System.out.println("Cannot insert at the start by this function");
			return;
		}
		if (pos == size) {
			System.out.println("Cannot insert at the end by this function");
			return;
		}
		pos = pos - 1;
		for (int i = 1; i < size; i++) {
			if (i == pos) {
				Node tmp = aNode.getNext();
				aNode.setNext(node);
				node.setNext(tmp);
				break;
			}
			aNode = aNode.getNext();
		}
		size++;
	}

	/**
	 * Function to delete an element at position
	 * 
	 * @param pos
	 *            position from which the item needs to be deleted (node position)
	 */
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getNext();
			size--;
			return;
		}
		if (pos == size) {
			Node s = start;
			Node t = start;
			while (s != end) {
				t = s;
				s = s.getNext();
			}
			end = t;
			end.setNext(null);
			size--;
			return;
		}
		Node aNode = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Node tmp = aNode.getNext();
				tmp = tmp.getNext();
				aNode.setNext(tmp);
				break;
			}
			aNode = aNode.getNext();
		}
		size--;
	}

	/**
	 * 
	 * @param val
	 *            accepts an int argument for the value to be searched
	 * @return the position of the data (node), -1 if not found
	 */
	public int findData(int val) {
		Node aNode = start;
		int position = 1;
		while (!aNode.equals(null)) {
			if (aNode.getData() == val) {
				System.out.println("Found in LinkedList");
				return position;
			}
			aNode = aNode.getNext();
			position++;
		}
		return -1;
	}

	/**
	 * 
	 * @param val
	 *            accepts an int argument for the value to be searched
	 * @return an int array with all the positions of the val in the linkedlist, -1
	 *         if not found
	 */
	public int[] findAll(int val) {
		int[] positions = new int[0];
		Node aNode = start;
		int position = 1;
		int i = 0;
		while (aNode != null) {
			if (aNode.getData() == val) {
				positions = Arrays.copyOf(positions, positions.length + 1);
				positions[i] = position;
				i++;
			}
			aNode = aNode.getNext();
			position++;
		}
		if (i == 0) {
			positions[0] = -1;
		}
		return positions;
	}

	/**
	 * updates the first occurrence of initialVal to newVal
	 * 
	 * @param initialVal
	 *                   old val to be updated
	 * @param newVal
	 *                   new value with which old val is replaced
	 */
	public void update(int initialVal, int newVal) {
		if (isEmpty()) {
			System.out.println("data does not exist to be updated.");
		}
		Node aNode = start;
		while (aNode != null) {
			if (aNode.getData() == initialVal) {
				aNode.setData(newVal);
				break;
			}
			aNode = aNode.getNext();
		}

	}

	/**
	 * updates all the occurrences of initialVal to newVal
	 * 
	 * @param initialVal
	 *                   old val to be updated
	 * @param newVal
	 *                   new value with which old val is replaced
	 */
	public void updateAll(int initialVal, int newVal) {
		if (this.size == 0) {
			System.out.println("data does not exist to be updated.");
		}
		Node aNode = start;
		while (aNode != null) {
			if (aNode.getData() == initialVal) {
				aNode.setData(newVal);
			}
			aNode = aNode.getNext();
		}
	}

	/**
	 * updates the value of a node at the position pos
	 * 
	 * @param pos
	 *               position of the node
	 * @param newVal
	 *               new value that needs to be updated at the pos
	 */
	public void updateAtPos(int pos, int newVal) {
		if (isEmpty()) {
			System.out.println("data does not exist to be updated.");
		}

		Node aNode = start;
		int position = 1;
		while (aNode != null) {
			if (position == pos) {
				aNode.setData(newVal);
				break;
			}
			aNode = aNode.getNext();
			position++;
		}
	}

	/**
	 * 
	 * @return the start reference of the linkedlist
	 */
	public Node getStart() {
		return start;
	}

	/**
	 * 
	 * @return the end reference of the linkedlist
	 */
	public Node getEnd() {
		return end;
	}
}
