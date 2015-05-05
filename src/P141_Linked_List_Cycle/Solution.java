package P141_Linked_List_Cycle;

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
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode p = head;
		ListNode q = head.next;
		while (p != null && q != null) {
			p = p.next;
			if (q.next != null)
				q = q.next.next;
			else
				return false;
			if (p == q)
				return true;
		}
		if (p == null || q == null)
			return false;
		return true;
	}
}
