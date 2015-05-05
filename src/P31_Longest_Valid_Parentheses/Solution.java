package P31_Longest_Valid_Parentheses;

import java.util.LinkedList;

public class Solution {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0 )return 0;
		
		int result = 0;
		int temp = 0;
		LinkedList<Character> sk = new LinkedList<Character>();
		LinkedList<Integer> stack = new LinkedList<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				sk.push('(');
				stack.push(i);
			} else if (!sk.isEmpty() && sk.pop() == '(') {
				stack.pop();
			} else {
				stack.push(i);
				sk.clear();
			}
		}
		if (stack.isEmpty()) return s.length();

		result = s.length() - stack.peek();
		while (!stack.isEmpty()) {
			int num1 = stack.peek();
			int num2;
			stack.pop();
			if (stack.isEmpty()) {
				num2 = -1;
			} else {
				num2 = stack.peek();
			}
			temp = num1 - num2;
			if (result < temp) result = temp;
		}

		return result - 1;
	}
}