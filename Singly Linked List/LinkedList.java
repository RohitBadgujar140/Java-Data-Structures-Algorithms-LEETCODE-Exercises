package datastructures.linkedlist;

class LinkedList {
	private Node head;
	private Node tail;
	private int length;

	LinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public void createLinkedList(int noOfNodes, int[] nodeValues) {
		Node newNode = new Node(nodeValues[0]);
		head = newNode;
		tail = newNode;
		length = 1;

		for (int i = 1; i < noOfNodes; i++) {
			Node nextNewNode = new Node(nodeValues[i]);
			tail.next = nextNewNode;
			tail = nextNewNode;
			length++;
		}
	}
	
	public void printLinkedList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
        System.out.println("\nhead: " + head.value + " tail: " + tail.value + " length: " + length);
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		tail.next = newNode;
		tail = newNode;
		length++;
	}
	
	public Node removeLast() {
		if (length == 0) {
			return null;
		}

		Node temp = head;
		Node prev = head;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}

		tail = prev;
		tail.next = null;
		length--;

		if (length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}
	
	public void prepend(int value) {
		Node newNode = new Node(value);

		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}
	
	public Node removeFirst() {
		if (length == 0) {
			return null;
		}

		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;

		if (length == 0) {
			tail = null;
		}
		return temp;
	}
	
	public Node get(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		
		if (index == length - 1) {
			return tail;
		}
		
		Node temp = head;
		for (int i = 0 ; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public boolean set(int index, int value) {
		Node temp = get(index);
		if (temp != null) {
			temp.value = value;
			return true;
		}
		return false;
	}
	
	public boolean insert(int index, int value) {
		if (index < 0 || index > length) {
			return false;
		}
		
		if (index == 0) {
			prepend(value);
			return true;
		}
		
		if (index == length) {
			append(value);
			return true;
		}
		
		Node newNode = new Node(value);
		Node prev = get(index - 1);
		newNode.next = prev.next;
		prev.next = newNode;
		length++;
		return true;
	}
	
	public Node remove(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		
		if (index == 0) {
			return removeFirst();
		}
		
		if (index == length - 1) {
			return removeLast();
		}
		
		Node prev = get(index - 1);
		Node current = prev.next;
		prev.next = current.next;
		current.next = null;
		length--;
		return current;
	}
	
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		Node after = temp.next;
		Node before = null;
		
		for (int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}
	
	public int getLength() {
		return length;
	}
}