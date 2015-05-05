package P129_Sum_Root_to_Leaf_Numbers;

import java.util.ArrayList;

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		TreeNode p;
		int counter = 1;
		int num;
		int result = 0;
		nodeList.add(root);
		valueList.add(root.val);
		while (!nodeList.isEmpty()) {
			int i = 0;
			int temp = 0;
			while (i < counter) {
				p = nodeList.remove(0);
				num = valueList.remove(0);
				if (p.left == null && p.right == null)
					result += num;
				if (p.left != null) {
					nodeList.add(p.left);
					valueList.add(num * 10 + p.left.val);
					temp++;
				}
				if (p.right != null) {
					nodeList.add(p.right);
					valueList.add(num * 10 + p.right.val);
					temp++;
				}
				i++;
			}
			counter = temp;
		}
		return result;
	}
}