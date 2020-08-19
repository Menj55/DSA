package com.ds.linkedlist;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class CustomLinkedList {

	public Node getLL() {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		return head;
	}
	
	public void printLL(Node head) {
		while(head!= null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomLinkedList c = new CustomLinkedList();
		Node head = c.getLL();
		c.printLL(head);
	}

}
