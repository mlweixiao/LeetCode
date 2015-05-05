package P94_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
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
	}
}

public class Solution {
	private List<Integer> al = new ArrayList<Integer>();

	public void midorder(TreeNode root) {
		if (root == null)
			return;
		midorder(root.left);
		al.add(root.val);
		midorder(root.right);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		midorder(root);
		return al;
	}
}
