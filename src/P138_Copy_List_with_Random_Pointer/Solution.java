package P138_Copy_List_with_Random_Pointer;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return (RandomListNode) null;
		RandomListNode p = head;
		while (p != null) {
			RandomListNode node = new RandomListNode(p.label);
			node.next = p.next;
			p.next = node;
			p = p.next.next;
		}
		p = head;
		RandomListNode q = head.next;
		while (p != null) {
			if (p.random != null)
				q.random = p.random.next;
			p = p.next.next;
			if (p != null)
				q = p.next;
			else
				break;
		}
		p = head;
		q = head.next;
		RandomListNode myhead = head.next;
		while (p != null) {
			p.next = p.next.next;
			p = p.next;
			if (p != null) {
				q.next = q.next.next;
				q = q.next;
			} else
				break;
		}
		return myhead;
	}
}
