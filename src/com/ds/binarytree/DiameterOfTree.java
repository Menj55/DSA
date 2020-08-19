package com.ds.binarytree;

import java.util.HashMap;

public class DiameterOfTree {

	class LCA {
		private Node lca;
		private int dist;
		
		LCA(){};
		LCA(int a, Node lca) {
			this.dist= a;
			this.lca = lca;
		}
	}
	
	private HashMap<Integer, LCA> map = new HashMap<>();
	
	private int height(Node root) {
		if(root == null)
			return 0;
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	
	private LCA diameter(Node root, Node lca) {
		if(root == null)
			return new LCA(0,null);
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		LCA ld = diameter(root.left, lca);
		LCA rd = diameter(root.right, lca);
		
		int d = Math.max(lh+rh+1, Math.max(ld.dist, rd.dist));
		
		if(!map.containsKey(d)) {
			if(lh + rh + 1 > Math.max(ld.dist, rd.dist)) {
				lca = root;
			} else if(ld.dist > rd.dist) {
				lca = root.left;
			} else {
				lca = root.right;
			}
			map.put(d, new LCA(d, lca));
		} else {
			lca = map.get(d).lca;
		}

		return new LCA(d, lca);
	}
	
	public Node givenLevel(Node root, int level) {
		if(root == null)
			return null;
		if(level == 1)
			return root;
		Node left = givenLevel(root.left, level-1);
		Node right = givenLevel(root.right, level-1);
		
		return right == null ? left : right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree t = new BinaryTree();
		Node root = t.getBST();
		Node lca = root;
		DiameterOfTree d = new DiameterOfTree();
		
		LCA temp = d.diameter(root, lca);
		System.out.println("LCA -> " + temp.lca.data + " Diameter " + temp.dist);
		int lh = d.height(temp.lca.left);
		int rh = d.height(temp.lca.right);
		
		System.out.println("Lh = "+ lh + " rh = "+ rh);
		Node left = d.givenLevel(temp.lca.left, lh);
		Node right = d.givenLevel(temp.lca.right, rh);
		
		System.out.println(left.data + "   --   "+ right.data);
	}

}
