package com.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomView {

	class VOD {
		Node node;
		int hd;
		
		VOD(int hd, Node node) {
			this.node = node;
			this.hd = hd;
		}
	}
	
	private void getVerticalOrder(Node root, HashMap<Integer,  List<Node>> map) {
		if(root == null)
			return;
		int hd = 0;
		
		Queue<VOD> q = new LinkedList<>();
		
		q.add(new VOD(hd,root));
		List<Node> tlist = new ArrayList();
		tlist.add(root);
		map.put(hd, tlist);
		
		while(!q.isEmpty()) {
			VOD temp = q.remove();
			hd = temp.hd;
			if(temp.node.left != null) {
				q.add(new VOD(hd-1, temp.node.left));
				List<Node> list = map.get(hd-1);
				if(list != null)
					list.add(temp.node.left);
				else {
					list = new ArrayList() ;
					list.add(temp.node.left);
				}
					
				map.put(hd-1, list);
			}
			
			if(temp.node.right != null) {
				q.add(new VOD(hd+1, temp.node.right));
				List<Node> list = map.get(hd+1);
				if(list == null)
					list = new ArrayList();
				list.add(temp.node.right);
				map.put(hd+1, list);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		Node root = tree.getBST();
		HashMap<Integer, List<Node>> map = new HashMap();
		BottomView b = new BottomView();
		b.getVerticalOrder(root.left.left, map);
//		System.out.println(map.toString());
		
		for(Integer x : map.keySet()) {
//			System.out.println("Key = "+ x + " Values are : " + map.get(x).toString());
			map.get(x).forEach(y -> {
				System.out.print(y.data + " ");
			});
			System.out.println();
		}
		
	}

}
