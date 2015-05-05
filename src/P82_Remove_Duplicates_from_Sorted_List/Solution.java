package P82_Remove_Duplicates_from_Sorted_List;

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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode p = head.next;
		ListNode q = head;
		while (p != null) {
			if (q.val == p.val) {
				p = p.next;
				q.next = p;
			} else {
				p = p.next;
				q = q.next;
			}
		}
		return head;
	}
}
