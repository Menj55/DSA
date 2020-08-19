package com.algo;
import java.util.Stack;

public class PrefixToInfixWithNoBracket {

	private static String removeBrackets(String exp) {
		String result = "";
		
		for(int i=0;i<exp.length();i ++) {
			char c = exp.charAt(i);
			
			if(c == '(' ) {
				while(i < exp.length() && exp.charAt(i) != ')') {
					i++;
				}
				result += "a";
			} else {
				result += c + "";
			}
		}
		
		return result;
	}
	
	private static Character getOperator(String exp) {
//		exp = removeBrackets(exp);
		
		if(exp.contains("+")) {
			return '+';
		} else if(exp.contains("-")) {
			return '-';
		} else if(exp.contains("*")) {
			return '*';
		} else if(exp.contains("/")) {
			return '/';
		}
		return null;
	}
		
	private static int prec(char ch) {
		switch(ch) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
			default:
				return -1;
		}
	}
	
	private static String postfixToInfix(String exp) {
		Stack<String> result = new Stack<>();
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
		
			if(Character.isLetterOrDigit(ch)) {
				result.push(Character.toString(ch));
			}else if(ch == '-' || ch=='/') {
				String val1 = result.pop();
				String val2 = result.pop();
				result.push("(" + val2 + ch + val1 + ")");
			}
			else {
				if(result.size() < 2) {
					return "Invalid Postfix expression";
				}
				String val1 = result.pop();
				String val2 = result.pop();
				Character op1 = getOperator(val1);
				Character op2 = getOperator(val2);
				if(op2 != null && prec(op2) < prec(ch) ||
						(op2 != null && (prec(op2) == prec(ch)) && (ch == '-' || ch == '/' ) )) {
					val2 = "(" + val2 + ")";
				}
				
				if(op1 != null && prec(op1) < prec(ch)) {
					val1 = "(" + val1 + ")";
				}
				
				result.push(val2 + ch + val1);
			}
		}
		return result.pop();
	}

	public static void main (String[] args) {
		String exp = "abc--";
		System.out.println(postfixToInfix(exp));
	}
}

//(prec(opr2) < prec(exp[i]) || ( (prec(opr2) == prec(exp[i])) && (exp[i] == '-' || exp[i] == '/' ) ) )

//a-(b-c)
//abc--
//(a-b) -c
//ba- -c
//ba-c-
//7-4-3

//a-bc-

//a-b-c

//ab- -c
//ab-c-
