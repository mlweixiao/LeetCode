package P92_Reverse_Linked_List_II;

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
	public ListNode inverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		ListNode p = head;
		ListNode cur;
		while (p != null) {
			cur = p;
			p = p.next;
			cur.next = dummy.next;
			dummy.next = cur;
		}
		return dummy.next;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy;
		ListNode q = dummy;

		int i = 0;
		while (i < n) {
			q = q.next;
			i++;
		}
		ListNode temp = q;
		q = q.next;
		temp.next = null;

		i = 1;
		while (i < m) {
			p = p.next;
			i++;
		}
		temp = p;
		p = p.next;
		temp.next = null;

		temp.next = inverseList(p);
		i = 0;
		p = dummy;
		while (i < n) {
			p = p.next;
			i++;
		}
		p.next = q;

		return dummy.next;
	}
}
