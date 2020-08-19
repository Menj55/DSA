package com.ds.linkedlist;

public class ReverseLL {

	public Node reverseLLItr(Node head) {
		if(head == null) {
			return null;
		}
		Node prev = null;
		Node curr = head;
		Node temp = null;
		while(curr.next != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		System.out.println("Curr " + curr.data );
		curr.next = prev;
		return curr;
	}
	
	public Node reverseLL(Node head) {
		if(head == null)
			return null;
		Node prev = head;
		Node curr = head.next;
		
		if(curr == null) {
			return prev;
		}
			
		Node root = reverseLL(head.next);
		curr.next = prev;
		prev.next = null;
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomLinkedList c = new CustomLinkedList();
		Node head = c.getLL();
		c.printLL(head);
		System.out.println();
		ReverseLL r = new ReverseLL();
		Node reversed = r.reverseLL(head);
		c.printLL(reversed);
		System.out.println();
		head = c.getLL();
		Node reverseditr = r.reverseLLItr(reversed);
		c.printLL(reverseditr);
		System.out.println();
	}

}
