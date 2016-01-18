package _01_CheckExpression;

import java.util.Stack;

public class CheckExpression_01 {

	public static boolean simpleCheck(String s) {
		int count = 0;
		if (s.charAt(0) != '(' || s.charAt(s.length()) != ')') {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')')
				{count--;}
			if (count < 0)
				{return false;}
			
		}
		return true;
	}

	public static boolean stackCheck(String s) {
		if (s.charAt(0) != '(' || s.charAt(s.length()-1) != ')') {
			return false;
		}

		Stack<String> BracketStack = new Stack<String>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				BracketStack.push("1");
			}
			if (s.charAt(i) == ')' && BracketStack.size() == 0) {
				return false;
			} else {
				BracketStack.pop();
			}

		}
		return true;
	}

	public static void main(String[] args) {
		String s = "()()())))((())(";
		System.out.println(simpleCheck(s));
	}
}
