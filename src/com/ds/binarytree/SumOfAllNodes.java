package com.ds.binarytree;

public class SumOfAllNodes {

	private int getSum(Node root) {
		if(root == null)
			return 0;
		
		int sumleft = getSum(root.left);
		int sumRight = getSum(root.right);
		
		return sumleft + sumRight + root.data;
	}
	
	private int getCountOfNodes(Node root) {
		if(root == null)
			return 0;
		
		int countleft = getCountOfNodes(root.left);
		int countRight = getCountOfNodes(root.right);
		
		return countleft + countRight + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree bt = new BinaryTree();
		
		Node root = bt.getBST();
		SumOfAllNodes s = new SumOfAllNodes();
		bt.inorderItr(root);
		System.out.println();
		System.out.println(s.getSum(root));
		System.out.println(s.getCountOfNodes(root));
	}

}
