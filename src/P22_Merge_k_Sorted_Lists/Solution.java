package P22_Merge_k_Sorted_Lists;

import java.util.ArrayList;
import java.util.List;

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
		ListNode head = new ListNode(-1);
		if (l1 == null && l2 == null)
			return null;
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

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0)
			return (ListNode) null;
		if (lists.size() == 1)
			return lists.get(0);

		List<ListNode> tempList = new ArrayList<ListNode>();
		for (int i = 1; i < lists.size(); i += 2) {
			ListNode tempNode = mergeTwoLists(lists.get(i), lists.get(i - 1));
			tempList.add(tempNode);
		}
		if (lists.size() % 2 != 0)
			tempList.add(lists.get(lists.size() - 1));
		return mergeKLists(tempList);
	}
}
