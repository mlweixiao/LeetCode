package P117_Populating_Next_Right_Pointers_in_Each_Node_II;

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
	public void connect_3(TreeLinkNode root) {
		LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if (root == null)return;
		TreeLinkNode p;
		int num = 1;
		queue.addLast(root);
		while (!queue.isEmpty()) {
			int i = 0;
			int temp = 0;
			while (i < num) {
				p = queue.pop();
				if (p.left != null) {
					queue.add(p.left);
					temp++;
				}
				if(p.right!=null){
					queue.add(p.right);
					temp++;
				}
				if(i!=num-1)p.next=queue.getFirst();
				i++;
			}
			num = temp;
		}
	}	
	public void connect(TreeLinkNode root) {
		if (null == root) {
			return;
		}

		TreeLinkNode cur = root.next;
		TreeLinkNode p = null;
		while (cur != null) { // find last right node (left or right)
			if (cur.left != null) {
				p = cur.left;
				break;
			}
			if (cur.right != null) {
				p = cur.right;
				break;
			}
			cur = cur.next;
		}

		if (root.right != null) {
			root.right.next = p;
		}
		if (root.left != null) {
			root.left.next = root.right != null ? root.right : p;
		}

		connect(root.right); // from right to left
		connect(root.left);
	}

	public void connect_2(TreeLinkNode root) {
		if (null == root) {
			return;
		}

		LinkedList<TreeLinkNode> Q = new LinkedList<TreeLinkNode>(); // save one																		// line																	// root(s)
		LinkedList<TreeLinkNode> Q2 = new LinkedList<TreeLinkNode>(); // save next one line root(s), swap with Q
		Q.push(root);

		while (!Q.isEmpty()) {
			TreeLinkNode tmp = Q.getFirst();
			Q.pop();

			if (tmp.left != null)
				Q2.add(tmp.left);
			if (tmp.right != null)
				Q2.add(tmp.right);

			if (Q.isEmpty()) {
				tmp.next = null;
				LinkedList<TreeLinkNode> tmpQ = Q; // swap queue
				Q = Q2;
				Q2 = tmpQ;
			} else {
				tmp.next = Q.getFirst();
			}
		}
	}

	public void connect_1(TreeLinkNode root) {
		LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if (root == null)
			return;
		TreeLinkNode p;
		queue.add(root);
		queue.add(null);// flag

		while (!queue.isEmpty()) {
			p = queue.pop();
			if (p != null) {
				if (p.left != null) {
					queue.add(p.left);
				}
				if (p.right != null) {
					queue.add(p.right);
				}
				p.next = queue.getFirst();
			} else {
				if (queue.isEmpty()) {
					return;
				}
				queue.add(null);
			}
		}
	}
}
