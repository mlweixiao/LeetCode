package P113_Path_Sum_II;

import java.util.ArrayList;

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
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        getSum(root, 0, sum);
        return result;
    }
	public void getSum(TreeNode root, int sum, int target){
		if(root == null) return;
		sum+= root.val;
		path.add(root.val);
		if(root.left == null && root.right == null && sum== target)
			result.add(new ArrayList<>(path));
		getSum(root.left, sum, target);
		getSum(root.right, sum, target);
		sum-=root.val;
		path.remove(path.size()-1);
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=22;
		TreeNode p1=new TreeNode(5);
		TreeNode p2=new TreeNode(4);
		TreeNode p3=new TreeNode(8);
		TreeNode p4=new TreeNode(11);
		TreeNode p5=new TreeNode(13);
		TreeNode p6=new TreeNode(4);
		TreeNode p7=new TreeNode(7);
		TreeNode p8=new TreeNode(2);
		TreeNode p9=new TreeNode(5);
		TreeNode p10=new TreeNode(1);
		p1.left=p2;
		p1.right=p3;
		p2.left=p4;
		p3.left=p5;
		p3.right=p6;
		p4.left=p7;
		p4.right=p8;
		p6.left=p9;
		p6.right=p10;
		Solution s=new Solution();
		System.out.println(s.pathSum(p1, sum));	
	}
}
