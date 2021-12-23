package linkedlist_queue;

import linkedList.singlyLinkedList.SinglyLinkedList;

/*
 * This class implements the logic of a queue using linked list
 *  
 * @author Thao Phung
 * August 29 2018
 */
public class CustomQueue {
	private SinglyLinkedList q;
	private Node front, rear;

	public CustomQueue() {
		q = new SinglyLinkedList();
		front = q.getStart();
		rear = q.getEnd();
	}

	public void updatePointers() {
		front = q.getStart();
		if (front == null) {
			rear = front;
			return;
		}
		rear = q.getEnd();
	}

	public void enqueue(int data) {
		q.insertAtEnd(data);
		updatePointers();
		System.out.print("Operation Enqueue-");
		display();
		if (front != null) {
			System.out.println("Front is:" + front.getData());
			System.out.println("Rear is:" + rear.getData());
		}
	}

	public void dequeue() {
		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}
		q.deleteAtPos(1);
		updatePointers();
		System.out.print("Operation Dequeue-");
		display();
		if (front != null) {
			System.out.println("Front is:" + front.getData());
			System.out.println("Rear is:" + rear.getData());
		}
	}

	public int peek() // return -1 in case Queue is empty
	{
		if (front == null) {
			System.out.println("Queue is empty");
			return -1;
		}
		return front.getData();
	}

	public boolean isEmpty() {
		return front == null ? true : false;
	}

	public void display() {
		System.out.print("\nQueue = ");
		if (q.getSize() == 0) {
			System.out.print("empty\n");
			return;
		}
		if (front.getNext() == null) {
			System.out.println(front.getData());
			return;
		}
		Node aNode = front;
		System.out.print(front.getData() + " <- ");
		aNode = front.getNext();
		while (aNode.getNext() != null) {
			System.out.print(aNode.getData() + " <- ");
			aNode = aNode.getNext();
		}
		System.out.print(aNode.getData() + "\n");
	}

	public int getSize()// -1 indicates that the queue is empty
	{
		if (front == null) {
			System.out.println("Queue is empty");
			return -1;
		}
		return q.getSize();
	}
}
