package P60_Rotate_List;

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
	public ListNode rotateRight(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		if (n < 1 || head == null)
			return head;

		ListNode p = head;

		int counter = 1;
		while (p.next != null) {
			p = p.next;
			counter++;
		}
		p.next = head;

		int i = 1;
		p = head;
		while (i < (counter - n % counter)) {
			p = p.next;
			i++;
		}
		dummy.next = p.next;
		p.next = null;
		return dummy.next;
	}
}
