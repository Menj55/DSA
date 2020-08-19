package com.ds.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RootToLeaf {

	private Stack<Integer> s = new Stack();
	private void rootToLeaf(Node root, List<List<Integer>> result) {
		if(root == null) {
			return;
		}
		s.push(root.data);
		rootToLeaf(root.left, result);
		if(root.left == null && root.right == null) {
			System.out.println(s.toString());
			result.add(new ArrayList(s));
		}
		rootToLeaf(root.right, result);
		s.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RootToLeaf r = new RootToLeaf();
		BinaryTree t = new BinaryTree();
		Node root = t.getBST();
		List<List<Integer>> result = new ArrayList<>();
		r.rootToLeaf(root, result);
		System.out.println(result.size());
		
		for(List<Integer> list : result) {
			list.forEach(x -> {
				System.out.print(x + " ");
			});
			System.out.println();
		}
	}

}
