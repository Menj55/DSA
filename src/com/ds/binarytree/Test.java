package com.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Test {

	private void recursiveFn(Node head, int num) {
		if(num == 0) {
			head.data = 2; //2
		} else {

			recursiveFn(head, num-1);
			System.out.println(num + "  -  "+ head.data);
		}
			
		
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		Node head = new Node(100); //1
		t.recursiveFn(head, 5);
		System.out.println(head.data);
		
	}

}
