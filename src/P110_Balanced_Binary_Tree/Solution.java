package P110_Balanced_Binary_Tree;

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
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int maxleft = maxDepth(root.left);
		int maxright = maxDepth(root.right);
		return 1 + (maxleft > maxright ? maxleft : maxright);
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int leftdepth = maxDepth(root.left);
		int rightdepth = maxDepth(root.right);
		if (Math.abs(leftdepth - rightdepth) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
}

/*public class Solution {
    public static class  Depth{  
        private int depth;  
    }
    
    public boolean isBalanced(TreeNode root, Depth d) {
		if (root == null) {
			d.depth = 0;
			return true;
		}
		Depth left=new Depth();
		Depth right=new Depth();
		if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
			int diff = left.depth - right.depth;
			if ((diff > 1) || (diff < -1)) {
				return false;
			}
			d.depth = 1 + (left.depth > right.depth ? left.depth : right.depth);
			return true;
		}
		return false;
	}
	
    public boolean isBalanced(TreeNode root) {
       	Depth temp=new Depth();
		return isBalanced(root,temp); 
    }
}*/
