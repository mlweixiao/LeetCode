package P124_Binary_Tree_Maximum_Path_Sum;

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
	static int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		PathSum(root);
		return max;
	}

	public int PathSum(TreeNode root) {
		if(root==null) return 0;
		int leftmaxsum=0;
		int rightmaxsum=0;
		int temp=root.val;
        if(root.left!=null){
        	leftmaxsum=Math.max(PathSum(root.left),0);
        } 
        if(root.right!=null){
        	rightmaxsum=Math.max(PathSum(root.right),0);
        }
        temp=root.val+leftmaxsum+rightmaxsum;
        max=max>temp?max:temp;
        return Math.max(root.val,Math.max(root.val+leftmaxsum, root.val+rightmaxsum));
    }
	
	public static void main(String []args){
		Solution s=new Solution();
		TreeNode []tn=new TreeNode [10];
		tn[1]=new TreeNode(1);
		tn[2]=new TreeNode(2);
		tn[3]=new TreeNode(3);
		tn[4]=new TreeNode(-4);
		tn[1].left=tn[2];
		tn[1].right=tn[3];
		System.out.println(s.maxPathSum(tn[4]));
	}
}
