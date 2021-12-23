package queue.arrayQueue;

/*
 * This class is a driver for the array queue
 *  
 * @author Thao Phung
 * August 29 2018
 */
import java.util.Scanner;

public class ArrayQueueDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class ArrayQueue */
		ArrayQueue q = new ArrayQueue();
		System.out.println("My queue: \n");
		/* Perform queue operations */
		while (true) {
			System.out.println("1. enqueue");
			System.out.println("2. dequeue");
			System.out.println("3. check empty");
			System.out.println("4. display");
			System.out.println("5. peek");
			System.out.println("6. get size");
			System.out.println("7. exit");
			int choice = scan.nextInt();
			switch (choice) {
				case 1: // enqueue
					System.out.println("Enter integer element to insert:");
					int val = scan.nextInt();
					q.enQueue(val);
					break;
				case 2: // dequeue
					q.deQueue();
					break;
				case 3: // check empty
					System.out.println("Empty status = " + q.isEmpty() + "\n");
					break;
				case 4: // display
					q.display();
					break;
				case 5: // peek
					System.out.println(q.peek() + "\n");
					break;
				case 6: // get size
					System.out.println("Size = " + q.getSize() + " \n");
					break;
				case 7: // terminate
					scan.close();
					System.exit(0);
				default:
					System.out.println("Wrong Entry \n ");
					break;

			}
		}
	}
}
