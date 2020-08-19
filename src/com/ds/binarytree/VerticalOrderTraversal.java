package com.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VerticalOrderTraversal {
	
	private void verticalOrderInline(Node root, HashMap<Integer, List<Node>> m) {
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		HashMap<Node, Integer> hd = new HashMap<>();
		q.add(root);
		Integer distance = 0;
		hd.put(root, distance);
		
		while(!q.isEmpty()) {
			Node temp = q.remove();
			distance = hd.get(temp);
			List<Node> list = m.get(distance);
			if(list != null) {
				list.add(temp);
			} else {
				list = new ArrayList();
				list.add(temp);
			}
			m.put(distance, list);
			if(temp.left != null) {
				q.add(temp.left);
				hd.put(temp.left, hd.get(temp) - 1);
			}
			
			if(temp.right != null) {
				q.add(temp.right);
				hd.put(temp.right, hd.get(temp) + 1);
			}
			
		}
	}
	
	private void printLevelOrder(Node root, HashMap<Integer, List<Node>> m, int hd) {
		if(root == null)
			return;
		List<Node> nodes = m.get(hd);
		if(nodes != null)
			nodes.add(root);
		else {
			nodes = new ArrayList();
			nodes.add(root);
		}
			
		m.put(hd, nodes);
		printLevelOrder(root.left, m, hd-1);
		printLevelOrder(root.right, m, hd+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree t = new BinaryTree();
		Node root = t.getBST();
		HashMap<Integer, List<Node>> m = new HashMap();
		VerticalOrderTraversal v = new VerticalOrderTraversal();
		
		v.printLevelOrder(root, m, 0);
		
		for(Integer key : m.keySet()) {
			List<Node> list = m.get(key);
			System.out.print("Level " + key + " --> ");
			list.forEach(data -> {
				System.out.print(data.data + " ");
			});
			System.out.println();
		}
		
		System.out.println("=======================");
		m = new HashMap();
		v.verticalOrderInline(root, m);
		
		for(Integer key : m.keySet()) {
			List<Node> list = m.get(key);
			System.out.print("Level " + key + " --> ");
			list.forEach(data -> {
				System.out.print(data.data + " ");
			});
			System.out.println();
		}
		
	}

}
