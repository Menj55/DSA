package com.ds.binarytree;

import java.util.Stack;

class Height{
	int h;
}

public class BinaryTree {

	public Node getBT() {
		Node temp = new Node(15);
		temp.left = new Node(0);
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.left.right = new Node(7);
		root.right.left.right = new Node(8);
		root.left.left.right.left = new Node(9);
		root.left.right.right = new Node(10);
		root.left.right.right.right = new Node(11);
		temp.left.left = root;
		return temp;
	}
	
	public Node getBST() {
		Node root = new Node(8);
		root.left = new Node(4);
		root.left.left = new Node(2);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(3);
		root.left.right = new Node(7);
		root.right = new Node(12);
		root.right.left = new Node(10);
		root.right.left.right = new Node(11);
		root.right.right = new Node(15);
		root.right.right.left = new Node(13);
		
		return root;
	}
	
	public void printInorder(Node root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}
	
	public void inorderItr(Node root) {
		Stack<Node> s = new Stack();
		
		Node curr = root;
		
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			if(!s.isEmpty()) {
				curr = s.pop();
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
		}
	}
	
	public void printPostorder(Node root) {
		if(root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public void postorderItr(Node root) {
		Stack<Node> s = new Stack();
		Node curr = root;
		
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			
			if(!s.isEmpty()) {
				curr = s.pop();
				curr = curr.right;
			}
			if(curr!= null && curr.left == null && curr.right == null) {
				System.out.print(curr.data + " ");
			}
		}
	}
	
	public int height(Node root) {
		if(root == null)
			return 0;
		
		return Math.max(height(root.left),height(root.right)) + 1;
	}
	
	public int diameter(Node root, Height h) {
		Height lh = new Height();
		Height rh = new Height();
		if(root == null) {
			h.h = 0;
			return 0;
		}
//		int lh = height(root.left);
//		int rh = height(root.right);
		
		int ld = diameter(root.left, lh);
		int rd = diameter(root.right, rh);
		
		h.h = Math.max(lh.h, rh.h) + 1;
		
		return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree t = new BinaryTree();
		Node root = t.getBST();
		System.out.println("------Inorder-------");
		t.printInorder(root);
		System.out.println();
		t.inorderItr(root);
		System.out.println();
		System.out.println();
		System.out.println("-------Postorder------");
		t.printPostorder(root);
		System.out.println();
//		t.postorderItr(root);
		System.out.println();
		Height h = new Height();
		h.h = t.height(root);
		System.out.println(t.diameter(root, h));
	}

}
