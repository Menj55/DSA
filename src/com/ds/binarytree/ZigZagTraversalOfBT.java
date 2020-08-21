package com.ds.binarytree;

import java.util.Stack;

public class ZigZagTraversalOfBT {

	private void zigZagTraversal(Node root) {
		if(root == null)
			return;
		
		Stack<Node> s1 = new Stack();
		Stack<Node> s2 = new Stack();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node temp = s1.pop();
				
				System.out.print(temp.data + "  ");
				if(temp.left != null)
					s2.push(temp.left);
				if(temp.right != null)
					s2.push(temp.right);
			}

			System.out.println();
			
			while(!s2.isEmpty()) {
				Node temp = s2.pop();
				
				System.out.print(temp.data + "  ");
				if(temp.right != null)
					s1.push(temp.right);
				if(temp.left != null)
					s1.push(temp.left);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		Node root = bt.getBST();
		
		ZigZagTraversalOfBT z = new ZigZagTraversalOfBT();
		
		z.zigZagTraversal(root);
		
	}

}
