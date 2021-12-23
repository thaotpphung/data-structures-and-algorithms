package linkedList.singlyLinkedList;

import java.util.Scanner;
/*
 * This class is a driver for the Singly or One way linked list
 *  
 * @author Thao Phung
 * August 29 2018
 */

import linkedlist_queue.Node;

public class SinglyLinkedListDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class linkedList */
		SinglyLinkedList list = new SinglyLinkedList();
		System.out.println("My Linked List");

		/* Perform list operations */
		while (true) {
			System.out.println("\nSingly Linked List Options\n");
			System.out.println("1. insert at begining");
			System.out.println("2. insert at end");
			System.out.println("3. insert at position");
			System.out.println("4. delete at position");
			System.out.println("5. check empty");
			System.out.println("6. get size");
			System.out.println("7. find all");
			System.out.println("8. update");
			System.out.println("9. update all");
			System.out.println("10. update at position");
			System.out.println("11. exit");

			int choice = scan.nextInt();
			switch (choice) {
				case 1: // Insert at beginning
					System.out.println("Enter integer element to insert");
					list.insertAtStart(scan.nextInt());
					break;
				case 2: // Insert at end
					System.out.println("Enter integer element to insert");
					list.insertAtEnd(scan.nextInt());
					break;
				case 3: // Insert at position
					System.out.println("Enter integer element to insert");
					int num = scan.nextInt();
					System.out.println("Enter position");
					int pos = scan.nextInt();
					if (pos <= 0 || pos > list.getSize())
						System.out.println("Invalid position\n");
					else
						list.insertAtPos(num, pos);
					break;
				case 4: // delete at position
					System.out.println("Enter position");
					int p = scan.nextInt();
					if (p < 1 || p > list.getSize())
						System.out.println("Invalid position\n");
					else
						list.deleteAtPos(p);
					break;
				case 5: // check empty
					System.out.println("Empty status = " + list.isEmpty());
					break;
				case 6: // get size
					System.out.println("Size = " + list.getSize() + " \n");
					break;
				case 7: // find all
					System.out.println("Enter integer element to find");
					int val = scan.nextInt();
					int[] positions = list.findAll(val);
					System.out.println("Positions : ");
					for (int i : positions) {
						System.out.print("" + i + " ");
					}
					break;
				case 8: // update
					System.out.println("Enter value that you want to update");
					int initialVal = scan.nextInt();
					System.out.println("Enter value that you want to update to");
					int newVal = scan.nextInt();
					list.update(initialVal, newVal);
					break;
				case 9: // update all
					System.out.println("Enter value that you want to update");
					int initialVal1 = scan.nextInt();
					System.out.println("Enter value that you want to update to");
					int newVal1 = scan.nextInt();
					list.updateAll(initialVal1, newVal1);
					break;
				case 10: // update at position
					System.out.println("Enter position that you want to update");
					int position = scan.nextInt();
					System.out.println("Enter value that you want to update to");
					int newVal3 = scan.nextInt();
					list.updateAtPos(position, newVal3);
					break;
				case 11: // terminate
					scan.close();
					System.exit(0);
				default:
					System.out.println("Wrong Entry \n ");
					break;
			}
			/* Display List */
			SinglyLinkedListDriver.display(list);
		}
	}

	/* Function to display elements */
	public static void display(SinglyLinkedList list) {
		Node start = list.getStart();
		System.out.print("\nLinked List = ");
		if (list.getSize() == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getNext() == null) {
			System.out.println(start.getData());
			return;
		}
		Node aNode = start;
		System.out.print(start.getData() + "->");
		aNode = start.getNext();
		while (aNode.getNext() != null) {
			System.out.print(aNode.getData() + "->");
			aNode = aNode.getNext();
		}
		System.out.print(aNode.getData() + "\n");
	}

}