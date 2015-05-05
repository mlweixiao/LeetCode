package P144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree
 */
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
//    private List<Integer> list=new ArrayList<Integer>();
//    public void preorder(TreeNode root){
//        if(root==null) return ;
//        list.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//    }
//    public List<Integer> preorderTraversal(TreeNode root) {
//        preorder(root);
//        return list;
//    }
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        List<Integer> list =new ArrayList<Integer>();
        TreeNode p = root;
        if(p == null) return list;
        stack.add(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            list.add(p.val);
            if(p.right != null)
                stack.push(p.right);
            if(p.left != null)
                stack.push(p.left);
        }
        return list;
    }
}
