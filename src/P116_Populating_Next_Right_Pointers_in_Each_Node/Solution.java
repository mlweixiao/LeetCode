package P116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;

/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {
	public void connect(TreeLinkNode root) {
		LinkedList<TreeLinkNode> linkedList = new LinkedList<TreeLinkNode>();
		if (root == null || root.left == null)
			return;
		TreeLinkNode p;
		int num = 1;
		linkedList.addLast(root);
		while (!linkedList.isEmpty()) {
			int i = 0;
			int temp = 0;
			while (i < num) {
				p = linkedList.pollFirst();
				if (p.left != null) {
					linkedList.addLast(p.left);
					linkedList.addLast(p.right);
					temp += 2;
				}
				if (i != num - 1)
					p.next = linkedList.getFirst();
				i++;
			}
			num = temp;
		}
	}
}
