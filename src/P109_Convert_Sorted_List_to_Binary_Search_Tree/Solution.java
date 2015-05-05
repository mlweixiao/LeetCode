package P109_Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

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
	public TreeNode sortedArray2BST(ArrayList<Integer> num, int start, int end) {
		int tmp = (start + end) / 2;
		TreeNode node = new TreeNode(num.get(tmp));
		if (start != tmp)
			node.left = sortedArray2BST(num, start, tmp - 1);
		if (tmp != end)
			node.right = sortedArray2BST(num, tmp + 1, end);

		return node;
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode p = head;
		ArrayList<Integer> array = new ArrayList<Integer>();
		while (p != null) {
			array.add(p.val);
			p = p.next;
		}
		int start = 0;
		int end = array.size() - 1;
		return sortedArray2BST(array, start, end);
	}
}
