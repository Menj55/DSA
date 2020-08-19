package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Mirror {

	private boolean isMirror(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 != null && root2 == null)
			return false;
		if(root1 == null && root2 != null)
			return false;
		if(root1.data != root2.data)
			return false;
		
		return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}
	
	private Node mirrorItr(Node root) {
		if(root == null)
			return null;
		Node left = mirrorItr(root.left);
		Node right = mirrorItr(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	private Node getMirror(Node root) {
		if(root == null) 
			return null;
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.remove();
			Node holder = temp.left;
			temp.left = temp.right;
			temp.right = holder;
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree b = new BinaryTree();
		Node root = b.getBST();
		
		Mirror m = new Mirror();
		b.printInorder(root);
		Node mirror = m.getMirror(root);
		System.out.println();
		b.printInorder(mirror);
		root = b.getBST();
//		Node mirroritr = m.mirrorItr(root);
		System.out.println();
//		b.printInorder(mirroritr);
		
		System.out.println("Is mirror = " + m.isMirror(root, mirror));
	}

}
