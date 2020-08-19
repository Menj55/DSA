package com.algo;

import java.util.Stack;

public class PostfixPrefixInfix {

	private int getPrec(Character str) {
		switch(str) {
			case '+' :
			case '-' :
				return 1;
			case '*' :
			case '/' :
				return 2;
		}
		return -1;
	}
	
	
	private String toPostfix(String str) {
		int n = str.length();
		String result = "";
		Stack<Character> s = new Stack();
		
		for(int i=0; i<n; i++) {
			char ch = str.charAt(i);
			if(Character.isDigit(ch)) {
				result += ch;
			} else {
				if(ch == '(') {
					s.push(ch);
				} else if(ch == ')') {
					while(!s.isEmpty() && s.peek() != '(') {
						result += s.pop();
					}
					
					if(s.isEmpty())
						return "Invalid String";
					if(s.peek()=='(')
						s.pop();
					
				} else {
					while(!s.isEmpty() && getPrec(ch) <= getPrec(s.peek())) {
						result += s.pop();
					}
					s.push(ch);
				}
			}
		}
		
		while(!s.isEmpty()) {
			result += s.pop();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "3*(2+5/9)";
		PostfixPrefixInfix p = new PostfixPrefixInfix();
		System.out.println(p.toPostfix(str));
	}

}
