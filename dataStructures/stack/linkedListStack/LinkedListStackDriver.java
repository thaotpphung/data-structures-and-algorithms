package stack.linkedListStack;

/*
 * This class is a driver for the linkedlist stack
 *  
 * @author Thao Phung
 * September 9 2018
 */
import java.util.Scanner;

public class LinkedListStackDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class LinkedListStack */
		LinkedListStack s = new LinkedListStack();
		System.out.println("My Stack\n");
		/* Perform stack operations */
		while (true) {
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Get Size");
			System.out.println("4. Display");
			System.out.println("5. Exit");

			int choice = scan.nextInt();
			switch (choice) {
				case 1: // push
					System.out.println("Enter integer element to insert");
					int data = scan.nextInt();
					s.push(data);
					break;
				case 2: // pop
					s.pop();
					break;
				case 3: // get size
					System.out.println("Size = " + s.getSize());
					break;
				case 4: // display
					s.display();
					break;
				case 5: // terminate
					scan.close();
					System.exit(0);
				default:
					System.out.println("Wrong Entry \n ");
					break;
			}

		}

	}

}
