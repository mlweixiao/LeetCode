package P83_Remove_Duplicates_from_Sorted_List_II;

import java.util.HashMap;

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

		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		ListNode cur = head.next;
		ListNode pre = head;
		hashmap.put(pre.val, 1);

		while (cur != null) {
			if (hashmap.containsKey(cur.val)) {
				int value = hashmap.get(cur.val).intValue();
				value++;
				hashmap.put(cur.val, value);
			} else {
				if (hashmap.get(pre.val).intValue() == 1) {
					p.next = pre;
					p = p.next;
					pre.next = null;
				}
				hashmap.clear();
				hashmap.put(cur.val, 1);
			}
			pre = cur;
			cur = cur.next;
		}
		if (hashmap.get(pre.val).intValue() == 1)
			p.next = pre;
		hashmap.clear();
		return dummy.next;
	}
}
