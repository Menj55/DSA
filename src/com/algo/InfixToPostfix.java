package com.algo;

import java.util.Stack;

public class InfixToPostfix {

	private int precedence(char ch) {
		switch(ch) {
			case '+' :
			case '-' :
				return 1;
			case '/' :
			case '*' :
				return 2;
			default :
				return -1;
		}
	}
	
	private String infixToPostfix(String str) {
		String result = "";
		int n = str.length();
		Stack<Character> s = new Stack();
		for(int i=0; i<n; i++) {
			char c = str.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				result += c;
			} else {
				if(c == '(' ) {
					s.push(c);
				} else if(c == ')') {
					while(!s.isEmpty() && s.peek()!= '(') {
						result += s.pop();
					}
					
					if(!s.isEmpty()) {
						s.pop();
					} else {
						System.out.println("Invalid Expression");
					}
					
				} else {
					while(!s.isEmpty() && precedence(c) <= precedence(s.peek())) {
						if(s.peek() == '(') {
							System.out.println("Invalid Expression");
							return "Invalid Expression";
						}
						result += s.pop();
					}
					s.push(c);
				}
				
			}
		}
		
		while(!s.isEmpty()) {
			if(s.peek() == '(') {
				System.out.println("Invalid Expression");
				return "Invalid Expression";
			}
			result += s.pop();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InfixToPostfix i = new InfixToPostfix();
		String str = "c*(a+b)";
		System.out.println(i.infixToPostfix(str));
	}

}
