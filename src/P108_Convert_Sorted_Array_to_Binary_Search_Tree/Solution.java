package P108_Convert_Sorted_Array_to_Binary_Search_Tree;

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
	public TreeNode sortedArray2BST(int[] num, int start, int end) {
		int tmp = (start + end) / 2;
		TreeNode node = new TreeNode(num[tmp]);
		if (start != tmp)
			node.left = sortedArray2BST(num, start, tmp - 1);
		if (tmp != end)
			node.right = sortedArray2BST(num, tmp + 1, end);

		return node;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
		int start = 0;
		int end = num.length - 1;
		return sortedArray2BST(num, start, end);
	}
}
