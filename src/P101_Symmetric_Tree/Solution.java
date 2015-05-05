package P101_Symmetric_Tree;

import java.util.Collections;
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
	public boolean isSymmetricTree_1(TreeNode p, TreeNode q) {
		while (p != null || q != null) {
			if (p == null && q != null)
				return false;
			if (p != null && q == null)
				return false;
			if (p.val == q.val) {
				return isSymmetricTree(p.left, q.right)
						&& isSymmetricTree(p.right, q.left);
			} else
				return false;
		}
		return true;
	}

	public boolean isSymmetricTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		LinkedList<TreeNode> st1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> st2 = new LinkedList<TreeNode>();
		st1.push(p);
		st2.push(q);
		while (!st1.isEmpty() && !st2.isEmpty()) {
			p = st1.pop();
			q = st2.pop();
			if (p == null && q == null)
				continue;
			if (p == null || q == null)
				return false;
			if (p.val != q.val)
				return false;
			Collections.addAll(st1, p.left, p.right);
			Collections.addAll(st2, q.right, q.left);
		}
		if (st1.isEmpty() && st2.isEmpty())
			return true;
		return false;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetricTree(root.left, root.right);
	}
}
