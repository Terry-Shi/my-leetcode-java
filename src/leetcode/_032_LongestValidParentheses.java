package leetcode;

import java.util.Stack;

public class _032_LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses("((((())"));
	}
	
	// 栈内只存放‘（’ ,不必存‘）’
	// 当前遍历到的 well-formed substring的长度=“未被打断”的出栈次数*2 或者用累计变量 length+=2
	// “被打断”就是遍历到‘）’时stack中无‘（’
	// 可以这样理解： “所有无法匹配的')'”的index其实都是各个well-formed substring的分界点。
	public static int longestValidParentheses(String s) {
		// 边界
		if (s == null || s.length() <= 1){
		    return -1;
		}
		
		int maxLen = 0;
		int len = 0;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) { //  没有“（”与之对应
					len = 0;
				} else {
					stack.pop();	 // 只要栈中有元素，就表示目前仍然是合格字符串
					len += 2;
					maxLen = Math.max(maxLen, len);
				}
			} else {
				return -1; // 不该出现的字符 
			}
		} 
		return maxLen;
	}
}
