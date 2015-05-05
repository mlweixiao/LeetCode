package P96_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		TreeNode p = root;
		if (p == null)
			return list;
		stack.add(p);
		while (!stack.isEmpty()) {
			p = stack.pop();
			list.add(p.val);
			if (p.right != null)
				stack.push(p.right);
			if (p.left != null)
				stack.push(p.left);
		}
		return list;
	}

	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {
					TreeNode temp = new TreeNode(i);
					temp.left = left.get(j);
					temp.right = right.get(k);
					result.add(temp);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 2;
		List<TreeNode> result = s.generateTrees(n);
		for (TreeNode root : result) {
			List<Integer> temp = s.preorderTraversal(root);
			System.out.println(temp.toString());
		}
	}
}
