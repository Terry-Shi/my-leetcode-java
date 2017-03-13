package leetcode;

import java.util.Stack;

public class _020_ValidParentheses {
	public static void main(String[] args) {
		// true cases
		System.out.println(isValidParentheses("()[]{}") == true);
		System.out.println(isValidParentheses("([]{})") == true);
		
		// false cases
		System.out.println(isValidParentheses("([]{}(") == false);
		System.out.println(isValidParentheses("(") == false);
	}
	
	public static boolean isValidParentheses(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i=0; i < s.length(); i++) {
			Character currChar = s.charAt(i);
			if (currChar == '(' || currChar == '[' || currChar == '{') {
				stack.push(currChar);
			} else if (currChar == ')' || currChar == ']' || currChar == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				Character charInStack = stack.pop();
				if (charInStack=='(' && currChar != ')') {
					return false;
				}
				if (charInStack=='[' && currChar != ']') {
					return false;
				}
				if (charInStack=='{' && currChar != '}') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
