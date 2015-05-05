package P23_Swap_Nodes_in_Pairs;

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

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = p.next;
		ListNode tmp;
		head = head.next;
		while (p != null && q != null) {
			tmp = p;
			p.next = q.next;
			q.next = p;
			p = p.next;
			if (p != null && p.next != null) {
				q = p.next;
				tmp.next = q;
			} else
				return head;
		}
		return head;
	}
}
