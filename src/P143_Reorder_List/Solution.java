package P143_Reorder_List;

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
	public ListNode  inverseList(ListNode head){
		if(head==null||head.next==null) return head;
		ListNode dummy=new ListNode(-1);
		ListNode p=head;
		ListNode cur;
		while(p!=null){
			cur=p;
			p=p.next;
			cur.next=dummy.next;
			dummy.next=cur;
		}
		return dummy.next;
	} 
	
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return ;
        ListNode p=head;
        ListNode q=head;
        ListNode tmp;
        while(q!=null){
        	tmp=p;
        	p=p.next;	
        	if(q.next!=null)q=q.next.next;
        	else{
        		tmp.next=null;
        		break;
        	}
        	if(q==null) tmp.next=null;
        }   
        q=inverseList(p);
        p=head;
        while(q!=null){
        	tmp=q.next;
        	q.next=p.next;
        	p.next=q;
        	q=tmp;
        	p=p.next.next;
        }
    }
}
