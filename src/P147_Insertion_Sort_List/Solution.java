package P147_Insertion_Sort_List;

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
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		ListNode p = head;
		ListNode q;
		ListNode temp;
		ListNode cur;

		while (p != null) {
			cur = p;
			p = p.next;
			cur.next = null;

			temp = dummy;
			q = dummy.next;

			while (q != null && q.val <= cur.val) {
				q = q.next;
				temp = temp.next;
			}
			temp.next = cur;
			cur.next = q;
		}

		return dummy.next;
	}
}