package P105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder,
			int s2, int e2) {
		if (s1 <= e1 && s2 <= e2) {
			TreeNode temp = new TreeNode(preorder[s1]);
			int i = s2;
			for (; i <= e2 && inorder[i] != preorder[s1]; i++);
			temp.left = buildTree(preorder, s1 + 1, s1 + i - s2, inorder, s2,
					i - 1);
			temp.right = buildTree(preorder, s1 + i - s2 + 1, e1, inorder,
					i + 1, e2);
			return temp;
		} else
			return null;
	}
}
