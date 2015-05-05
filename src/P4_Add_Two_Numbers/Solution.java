package P4_Add_Two_Numbers;

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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode pCurNode = dummy;
		int v1, v2, sum;
		int forward = 0;
		while (l1 != null || l2 != null) {
			v1 = (l1 != null ? l1.val : 0);
			v2 = (l2 != null ? l2.val : 0);
			sum = v1 + v2 + forward;
			forward = sum / 10;
			sum = sum % 10;
			ListNode pNode = new ListNode(sum);
			pCurNode.next = pNode;
			pCurNode = pNode;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (forward > 0) {
			ListNode pNode = new ListNode(forward);
			pCurNode.next = pNode;
		}
		return dummy.next;
	}

}
