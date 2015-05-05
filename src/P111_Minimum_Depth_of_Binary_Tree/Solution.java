package P111_Minimum_Depth_of_Binary_Tree;

import java.util.LinkedList;

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
	public int minDepth(TreeNode root) {
		int result = 0;
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		if (root == null)
			return 0;
		TreeNode p;
		int num = 1;
		linkedList.addLast(root);
		while (!linkedList.isEmpty()) {
			int i = 0;
			int temp = 0;
			while (i < num) {
				p = linkedList.pollFirst();
				if (p.left == null && p.right == null)
					return result + 1;
				if (p.left != null) {
					linkedList.addLast(p.left);
					temp++;
				}
				if (p.right != null) {
					linkedList.addLast(p.right);
					temp++;
				}
				i++;
			}
			num = temp;
			result++;
		}
		return result;
	}
}
