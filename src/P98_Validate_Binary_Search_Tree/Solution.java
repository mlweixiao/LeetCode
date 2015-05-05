package P98_Validate_Binary_Search_Tree;

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
	public boolean isValid(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (min >= root.val || root.val >= max)
			return false;
		return isValid(root.left, min, root.val)
				&& isValid(root.right, root.val, max);
	}

	public boolean isValidBST(TreeNode root) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return isValid(root, min, max);
	}
	
//	private ArrayList<Integer> al=new ArrayList<Integer>();
//	public void midorder(TreeNode root){
//		if(root==null) return ;
//		midorder(root.left);
//		al.add(root.val);
//		midorder(root.right);
//	}
//	public boolean isValidBST(TreeNode root) {
//	    al.clear();
//	    midorder(root);
//		for(int i=1;i<al.size();i++){
//			if(al.get(i-1)<al.get(i)) continue;
//			else return false;		
//		}
//		return true;
//    }
}
