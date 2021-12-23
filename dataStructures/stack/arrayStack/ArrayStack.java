package stack.arrayStack;

/*
 * This class implements the logic of a stack using array
 * @author Thao Phung 
 * September 7 2018 
 *  
 * Thao Phung
 */
public class ArrayStack {
	private final int MAX_SIZE = 10;
	private int top;
	private int sSize;
	private int[] stack;

	/**
	 * Constructor to construct an empty array of size 10 and a stack implements
	 * that array
	 */
	public ArrayStack() {
		stack = new int[MAX_SIZE];
		top = -1;
		sSize = 0;
	}

	/**
	 * Method to push datq into the stack
	 * 
	 * @param data
	 *             data to be pushed
	 */
	public void push(int data) {
		if (sSize == MAX_SIZE) {
			System.out.println("You have reached the end of the stack");
			return;
		}
		if (top == -1)
			top = 0;
		else {
			top++;
		}
		stack[top] = data;
		sSize++;
		System.out.println("\nOperation push -");
		display();
	}

	/**
	 * Method to pop data out of the stack
	 */
	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		top--;
		sSize--;
		System.out.println("\nOperation pop -");
		display();
	}

	/**
	 * Method to get the size of the stack
	 * 
	 * @return the size of the stack
	 */
	public int getSize() {
		if (isEmpty()) {
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
		if (isEmpty()) {
			System.out.print("empty\n");
			return;
		}
		System.out.print(stack[0]);
		for (int i = 1; i <= top; i++) {
			System.out.print(" - " + stack[i]);

		}
		System.out.println("\n");
	}

	/**
	 * Method to check if a stack is empty
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return sSize == 0;
	}
}