package P99_Recover_Binary_Search_Tree;

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	private TreeNode findMin(TreeNode root) {
		TreeNode result, l = root, r = root;
		if (root.left != null)
			l = findMin(root.left);
		if (root.right!= null)
			r = findMin(root.right);
		result = l.val < r.val ? l : r;
		return result.val < root.val ? result : root;
	}

	private TreeNode findMax(TreeNode root) {
		TreeNode result, l = root, r = root;
		if (root.left != null)
			l = findMax(root.left);
		if (root.right != null)
			r = findMax(root.right);
		result = l.val > r.val ? l : r;
		return result.val > root.val ? result : root;
	}

	public void recoverTree(TreeNode root) {
		TreeNode l=root,r=root;
		if(root==null||(root.left==null&&root.right==null)) return;
		if(root.left!=null) l=findMax(root.left);
		if(root.right!=null) r=findMin(root.right);
		
		if(l.val>r.val){
			int temp=l.val;
			l.val=r.val;
			r.val=temp;
			return ;
		}else if(l.val>root.val){
			int temp=l.val;
			l.val=root.val;
			root.val=temp;
			return ;
		}else if(r.val<root.val){
			int temp=r.val;
			r.val=root.val;
			root.val=temp;
			return ;
		}else{
			recoverTree(root.left);
			recoverTree(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1=new TreeNode(1); 
		TreeNode t2=new TreeNode(2); 
		TreeNode t3=new TreeNode(3); 
		TreeNode t4=new TreeNode(4); 
		//t2.left=t1;
		t1.right=t3;
		//t2.right=t3;
		t3.left=t2;
		Solution s=new Solution();
		s.recoverTree(t1);
		System.out.println(t1.val+" "+t2.val+" "+t3.val+" "+t4.val);
	}

}
