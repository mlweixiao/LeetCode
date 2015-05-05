package P112_Path_Sum;

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
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		
		LinkedList<TreeNode> s = new LinkedList<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode temp = s.peek();
			s.pop();
			if (temp.right != null) {
				temp.right.val += temp.val;
				s.push(temp.right);
			}
			if (temp.left != null) {
				temp.left.val += temp.val;
				s.push(temp.left);
			}
			if (temp.left == null && temp.right == null && temp.val == sum)
				return true;
		}
		return false;
	}
}
