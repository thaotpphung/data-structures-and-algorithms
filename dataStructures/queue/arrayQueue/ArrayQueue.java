package queue.arrayQueue;

/**
 * This class implements the logic of a queue using array
 * 
 * @author Thao Phung
 *         September 7 2018
 * 
 *         Thao Phung
 */
public class ArrayQueue {
	private final int MAX_SIZE = 10;
	private int front;
	private int rear;
	private int qSize;
	private int[] queue;

	/**
	 * Constructor to construct an empty array of size 10 and a queue implements
	 * that array
	 */
	public ArrayQueue() {
		queue = new int[MAX_SIZE];
		front = -1;
		rear = -1;
		qSize = 0;
	}

	/**
	 * Method to add data to the end of the queue
	 * 
	 * @param data data to be added
	 */
	public void enQueue(int data) {
		if (((rear + 1) % MAX_SIZE) == front) {
			System.out.println("You have reached the max length");
			return;
		}
		if (isEmpty()) {
			front = rear = 0;
		} else {
			rear = (rear + 1) % MAX_SIZE;
		}
		queue[rear] = data;
		qSize++;
		System.out.print("Operation enQueue -");
		display();
		System.out.println("Front is: " + queue[front]);
		System.out.println("Rear is: " + queue[rear] + "\n");
	}

	/**
	 * Method to remove data from the beginning of the queue
	 */
	public void deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty\n");
			return;
		}
		if (front == rear) {
			front = rear = -1;
			System.out.println("Operation deQueue -");
			System.out.println("Queue is empty\n");
			qSize--;
			return;
		}
		front++;
		qSize--;
		System.out.println("Operation deQueue -");
		display();
		System.out.println("Front is: " + queue[front]);
		System.out.println("Rear is: " + queue[rear] + "\n");

	}

	/**
	 * Method to get the first element of queue
	 * 
	 * @return the first element if the queue is not empty, -1 otherwise
	 */
	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return queue[front];
	}

	/**
	 * Method to check the empty status of the queue
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return this.qSize == 0;
	}

	/**
	 * Method to display the elements in the queue
	 */
	public void display() {
		System.out.print("\nQueue = ");
		if (isEmpty()) {
			System.out.println("empty\n");
			return;
		}
		if (front <= rear) {
			System.out.print(queue[front]);
			for (int i = front + 1; i <= rear; i++) {
				System.out.print(" <- " + queue[i]);
			}
		} else if (front > rear) {
			System.out.print(queue[0]);
			for (int i = 1; i <= rear; i++) {
				System.out.print(" <- " + queue[i]);
			}
			for (int i = front; i <= MAX_SIZE - 1; i++) {
				System.out.print(" <- " + queue[i]);
			}
		}
		System.out.println();
	}

	/**
	 * Method to get the size of the queue
	 * 
	 * @return the size of the queue if the queue is not empty, -1 otherwise
	 */
	public int getSize() // -1 indicates that the queue is empty
	{
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return qSize;

	}
}
