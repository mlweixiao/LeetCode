package P106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

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
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int s1, int e1, int[] postorder,
			int s2, int e2) {
		if (s1 <= e1 && s2 <= e2) {
			TreeNode temp = new TreeNode(postorder[e2]);
			int i = s1;
			for (; i <= e1 && inorder[i] != postorder[e2]; i++);
			temp.left = buildTree(inorder, s1, i - 1, postorder, s2, s2 + i - 1
					- s1);
			temp.right = buildTree(inorder, i + 1, e1, postorder, s2 + i - s1,
					e2 - 1);
			return temp;
		} else
			return null;
	}
}
