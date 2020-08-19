package com.algo;

import java.util.Stack;

public class PrefixToInfix {

	private String prefixToInfix(String str) {
		String result = "";
		Stack<String> s = new Stack();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(Character.isDigit(c)) {
				s.push(c+"");
			} else {
				if(s.size() < 2) {
					return "Invalid Expression";
				}
				String val1 = s.pop();
				String val2 = s.pop();
				
				s.push("(" + val2 + c + val1 + ")");
			}
		}
		result = s.pop();
		return s.isEmpty() ? result : "Invalid Expression";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "123--";
		PrefixToInfix p = new PrefixToInfix();
		System.out.println(p.prefixToInfix(str));
	}
}