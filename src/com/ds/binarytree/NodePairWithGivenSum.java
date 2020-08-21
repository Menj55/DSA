package com.ds.binarytree;

import java.util.Stack;

public class NodePairWithGivenSum {

	private void findNodePair(Node root) {
		if(root != null)
			return;
		
		Stack<Node> left = new Stack();
		Stack<Node> right = new Stack();
		
		left.push(root);
		right.push(root);
		
		while(true) {
			Node leftNode = left.pop();
//			while()
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree bt = new BinaryTree();
		Node root = bt.getBST();
		NodePairWithGivenSum n = new NodePairWithGivenSum();
		
	}

}
