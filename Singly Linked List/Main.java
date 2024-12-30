package datastructures.linkedlist;

import java.util.Scanner;

class Main {
	private static LinkedList linkedList;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		char resume = 'Y';

		System.out.println("***** Linked List Operations *****");
		
		do {
			
		System.out.println("\n1. Create 2. Print 3. Append 4. RemoveLast 5. Prepend 6. RemoveFirst 7. GetValueAtIndex 8. ModifyValueAtIndex 9. InsertItemAtIndex 10. RemoveItemAtIndex 11. ReverseList 12. Exit");
			
		System.out.println("Enter your choice");
		choice = scanner.nextInt();
		
		switch (choice) {
			case 1: {
				System.out.println("How many items do you want in your linked list?");
				int noOfNodes = scanner.nextInt();

				int[] nodeValues = new int[noOfNodes];
				
				System.out.print("Enter " + noOfNodes + " items seperated by single space ");
				
				for (int i = 0; i < noOfNodes; i++) {
					int value = scanner.nextInt();
					nodeValues[i] = value;
				}
				
				linkedList = new LinkedList();
				linkedList.createLinkedList(noOfNodes, nodeValues);
				linkedList.printLinkedList();
				break;				
			}
			
			case 2: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				linkedList.printLinkedList();
				break;		
			}
			
			case 3: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				System.out.println("Enter item which you want append to your linked list ");
				int data = scanner.nextInt();
				linkedList.append(data);
				linkedList.printLinkedList();
				break;
			}
			
			case 4: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				LinkedList.Node temp = linkedList.removeLast();
				System.out.println("Deleted item " + temp.value);
				linkedList.printLinkedList();
				break;
			}
			
			case 5: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				System.out.println("Enter item which you want prepend to your linked list ");
				int data = scanner.nextInt();
				linkedList.prepend(data);
				linkedList.printLinkedList();
				break;
			}
			
			case 6: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				LinkedList.Node temp = linkedList.removeFirst();
				System.out.println("Deleted item " + temp.value);
				linkedList.printLinkedList();
				break;
			}
			
			case 7: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				int index;
				boolean isValidIndex = false;
				LinkedList.Node temp;

				do {
					System.out.println("Enter index to find item on it in linked list ");
					index = scanner.nextInt();
					temp = linkedList.get(index);
					
					if (temp == null) {
						System.out.println("Invalid Index. Length of Linked List " + linkedList.getLength());
						isValidIndex = true;
					}
				} while (isValidIndex);

				System.out.print("Item at index " + index + " is "+ temp.value);
				linkedList.printLinkedList();
				break;
			}
		
			case 8: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				int index, value;

				System.out.println("Enter index on which you want to modify value in linked list ");
				index = scanner.nextInt();
				System.out.println("Enter value to set on index " + index + " in linked list");
				value = scanner.nextInt();

				boolean result = linkedList.set(index, value);
				
				if (!result) {
					System.out.println("Failed! Invalid Index " + index + " Length of Linked List " + linkedList.getLength());
				} else {
					System.out.println("Success! Value " + value + " is modified at index " + index);
				}

				linkedList.printLinkedList();
				break;
			}
			
			case 9: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				int index, value;

				System.out.println("Enter index on which you want to insert item in linked list ");
				index = scanner.nextInt();
				System.out.println("Enter item for given index " + index + "in linked list");
				value = scanner.nextInt();
				
				boolean result = linkedList.insert(index, value);
				
				if (!result) {
					System.out.println("Failed! Invalid Index " + index + " Length of Linked List " + linkedList.getLength());
				} else {
					System.out.println("Success! Value " + value + " is added at index " + index);
				}

				linkedList.printLinkedList();
				break;
			}
			
			case 10: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				int index;

				System.out.println("Enter index to remove item on it in linked list");
				index = scanner.nextInt();
				
				LinkedList.Node temp = linkedList.remove(index);
				if (temp != null) {
					System.out.println("Deleted item " + temp.value + " on given index " + index);
				} else {
					System.out.println("Failed! Invalid Index " + index + " Length of Linked List " + linkedList.getLength());
				}

				linkedList.printLinkedList();
				break;
			}
			
			case 11: {
				if (isLinkedListEmpty()) {
					break;
				}
				
				linkedList.reverse();
				linkedList.printLinkedList();
				break;
			}
				
			case 12: {
				resume = 'N';
				break;
			}
			
			default: {
				System.out.print("Please check your input again");
				break;
			}
		
		}
		
		} while (resume == 'Y');

		scanner.close();
	}
	
	public static boolean isLinkedListEmpty() {
		if (linkedList == null) {
			System.out.println("You need to create the linked list first (Case 1).");
			
			return true;
		}
		
		return false;
	}
}