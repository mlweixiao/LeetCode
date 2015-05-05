package P64_Merge_Two_Sorted_Lists;

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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		ListNode head = new ListNode(-1);
		ListNode pNode = head;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				pNode.next = l2;
				return head.next;
			}
			if (l2 == null) {
				pNode.next = l1;
				return head.next;
			}
			if (l1.val > l2.val) {
				pNode.next = l2;
				l2 = l2.next;
			} else {
				pNode.next = l1;
				l1 = l1.next;
			}
			pNode = pNode.next;
		}
		return head.next;
	}
}
