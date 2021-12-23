package linkedlist_queue;

/*
 * This class is a driver for the CustomQueue
 *  
 * @author Thao Phung
 * August 29 2018
 */

import java.util.Scanner;

public class CustomQueueDriver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        CustomQueue q = new CustomQueue();
        System.out.println("My Queue");

        /* Perform list operations */
        while (true) {
            System.out.println("\nQueue Options\n");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Check Empty?");
            System.out.println("4. Display");
            System.out.println("5. Peek");
            System.out.println("6. Get Size");
            System.out.println("7. exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: // Enqueue
                    System.out.println("Enter integer element to insert");
                    q.enqueue(scan.nextInt());
                    break;
                case 2: // Dequeue
                    q.dequeue();
                    q.display();
                    break;
                case 3: // Check empty
                    System.out.println(q.isEmpty() ? "Empty" : "Not Empty");
                    break;
                case 4: // display
                    q.display();
                    break;
                case 5: // peek
                    System.out.println(q.peek());
                    break;
                case 6: // get size
                    System.out.println("Size = " + q.getSize());
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
