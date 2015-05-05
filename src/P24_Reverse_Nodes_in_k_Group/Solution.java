package P24_Reverse_Nodes_in_k_Group;

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
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dumny = new ListNode(-1);
		ListNode pro=dumny;
		dumny.next = head;
		ListNode p = head;
		ListNode _k=head;
		ListNode cur;
		int i;
		
		for(;;) {			
			for(i=0;i<k;i++){
				if(_k==null) return dumny.next;
				_k=_k.next;	
			}
			
			head=pro.next;
			p=head;
			
			for(i=0;i<k;i++){
				cur = p;
				p = p.next;
				cur.next = pro.next;
				pro.next = cur;		
			}
			
			pro=head;
			pro.next=p;
			head=p;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		ListNode p3=new ListNode(3);
//		ListNode p4=new ListNode(4);
//		ListNode p5=new ListNode(5);
//		ListNode p6=new ListNode(6);
//		ListNode p7=new ListNode(7);
//		ListNode p8=new ListNode(8);
//		ListNode p9=new ListNode(9);
//		ListNode p10=new ListNode(10);
//		ListNode p11=new ListNode(11);
//		ListNode p12=new ListNode(12);
		p1.next=p2;
		p2.next=p3;
		//p3.next=p4;
		//p4.next=p5;
		//p5.next=p6;
		//p6.next=p7;
		//p7.next=p8;
		//p8.next=p9;
		
		Solution s=new Solution();
		ListNode re=s.reverseKGroup(p1, 1);
		while(re!=null){
			System.out.print(re.val+" ");
			re=re.next;
		}
	}

}
