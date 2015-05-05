package P86_Partition_List;

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
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy;
		while (p.next != null) {
			if (p.next.val >= x)
				break;
			p = p.next;
		}

		ListNode cur = p.next;
		ListNode q = p;
		while (cur != null) {
			if (cur.val < x) {
				q.next = cur.next;
				cur.next = p.next;
				p.next = cur;
				p = p.next;
				cur = q.next;
			} else {
				cur = cur.next;
				q = q.next;
			}
		}
		return dummy.next;
	}
}
