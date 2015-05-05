package P19_Remove_Nth_Node_From_End_of_List;

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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode pPre = null;
		ListNode p = head;
		ListNode q = head;
		for (int i = 0; i < n - 1; i++)
			q = q.next;

		while (q.next != null) {
			pPre = p;
			p = p.next;
			q = q.next;
		}

		if (pPre == null)
			head = p.next;
		else
			pPre.next = p.next;

		return head;
	}
}
