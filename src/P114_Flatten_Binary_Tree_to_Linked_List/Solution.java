package P114_Flatten_Binary_Tree_to_Linked_List;

import java.util.LinkedList;


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
    public void flatten(TreeNode root) {
        if(root == null) return ;
        
    	LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode p = root;
        stack.add(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            if(p.right != null)
                stack.push(p.right);
            if(p.left != null)
                stack.push(p.left);
            if(p.left==null&&p.right==null){
            	if(!stack.isEmpty())
            	    p.left=stack.peek();
            }
        }
        p = root;
        while(p!=null){
        	if(p.left!=null) p.right=p.left;
        	p.left=null;
        	p=p.right;
        }
    }
}
