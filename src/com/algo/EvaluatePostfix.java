package com.algo;

import java.util.EmptyStackException;
import java.util.Stack;

public class EvaluatePostfix {

	private int evaluatePostfix(String str) {
		Stack<Integer> s = new Stack();
		
		for(int i=0; i<str.length();i++) {
			char c = str.charAt(i);
			if(Character.isDigit(c)) {
				s.push(c - '0');
			} else {
				try {
					int val1 = s.pop();
					int val2 = s.pop();
					switch(c) {
					case '+' :
						s.push(val2 + val1);
						break;
					case '-' :
						s.push(val2 - val1);
						break;
					case '*' :
						s.push(val2 * val1);
						break;
					case '/' :
						s.push(val2/val1);
						break;
					default :
						System.out.println("Invalid Operation");
				}
				} catch(EmptyStackException e) {
					System.out.println("Invalid Expression");
					return -1;
				}
			}
		}
		
		if(s.size() != 1) {
			System.out.println("Invalid Expression");
			return -1;
		} else {
			return s.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvaluatePostfix e = new EvaluatePostfix();
		
		String str = "231*+9-+";
		System.out.println(e.evaluatePostfix(str));
	}

}
