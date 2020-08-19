package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

	private void printLevelGeek(Node root, int level) {
		if(root == null)
			return;
		
		if(level == 1) {
			System.out.print(root.data + " ");
			return;
		}
		
		printLevelGeek(root.left, level-1);
		printLevelGeek(root.right, level-1);
	}
	
	private void printGivenLevel(Node root, int level) {
		Queue<Node> q = new LinkedList<>();
		int curr = 0;
		if(root == null) {
			return;
		}
		
		q.add(root);
		q.add(null);
		curr++;
		while(!q.isEmpty()) {
			if(curr == level) {
				while(!q.isEmpty()) {
					Node temp = q.remove();
					if(temp != null)
						System.out.print(temp.data + " ");
				}
				break;
			}
			Node temp = q.remove();
			if(temp != null) {
				if(temp.left != null) {
					q.add(temp.left);
				}
				if(temp.right != null) {
					q.add(temp.right);
				}
			} else {
				q.add(null);
				curr++;
			}
		}
	}
	
	private void rightView(Node root) {
		Queue<Node> q = new LinkedList<>();
		boolean isFirst = true;
		if(root == null)
			return;
		q.add(root); 
		q.add(null);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			if(isFirst) {
				System.out.print(temp.data + " ");
				isFirst = false;
			}
				
			if(temp != null){
				if(temp.right != null)
					q.add(temp.right);
				if(temp.left != null)
					q.add(temp.left);
			} else {
				if(q.peek() == null)
					break;
				q.add(null);
				isFirst = true;
			} 
		}
	}
	
	private void leftView(Node root) {
		Queue<Node> q = new LinkedList<>();
		boolean isFirst = true;
		if(root == null)
			return;
		q.add(root); 
		q.add(null);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			if(isFirst) {
				System.out.print(temp.data + " ");
				isFirst = false;
			}
				
			if(temp != null){
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			} else {
				if(q.peek() == null)
					break;
				q.add(null);
				isFirst = true;
			} 
		}
	}
	
	private void printLevelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		if(root == null)
			return;
		q.add(root); 
		q.add(null);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			
			if(temp != null){
				System.out.print(temp.data + " ");
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			} else {
				if(q.peek() == null)
					break;
				System.out.println();
				q.add(null);
			} 
		}
	}
	
	private void printLevelOrderInLine(Node root) {
		Queue<Node> q = new LinkedList<>();
		
		if(root == null)
			return;
		q.add(root); 
		
		while(!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree t = new BinaryTree();
		Node root = t.getBST();
		LevelOrder l = new LevelOrder();
//		l.printLevelOrderInLine(root);
//		System.out.println();
//		System.out.println("--------------------------------------------");
		l.printLevelOrder(root);
//		l.leftView(root);
//		System.out.println();
//		l.rightView(root);
//		l.printGivenLevel(root, 4);
//		System.out.println();
//		l.printLevelGeek(root, 4);
	}

}
