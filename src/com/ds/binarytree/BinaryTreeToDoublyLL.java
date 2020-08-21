package com.ds.binarytree;

public class BinaryTreeToDoublyLL {

	Node head;
	Node prev = null;
	
	private void getDll(Node root) {
		
		if(root == null) 
			return;
		
		getDll(root.left);
		
		if(prev == null) {
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		
		prev = root;
		getDll(root.right);		
	}	
	private void printDLL() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.right;
		}
		System.out.println();	
		temp = head;
		System.out.println("Doubly Linked List Reversed");
		while(temp.right != null)
			temp = temp.right;
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.left;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		Node root = bt.getBST();
		BinaryTreeToDoublyLL b = new BinaryTreeToDoublyLL();
		System.out.println("Inorder of Binary Tree");
		bt.inorderItr(root);
		System.out.println();
		b.getDll(root);
		System.out.println();
		System.out.println("Doubly Linked List");
		b.printDLL();
	}

}
