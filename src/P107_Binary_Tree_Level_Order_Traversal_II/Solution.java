package P107_Binary_Tree_Level_Order_Traversal_II;

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

	TreeNode(int x) {
		val = x;
	}
}
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<Integer> list ;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList <TreeNode> linkedList = new LinkedList<TreeNode>();
        if(root == null) return result;
        TreeNode p;
        int num = 1;
        linkedList.addLast(root);
        while(!linkedList.isEmpty()) {
        	list = new ArrayList<Integer>();
            int i = 0;
            int temp = 0;
            while(i < num) {
                p = linkedList.pollFirst();
                list.add(p.val);
                if(p.left != null) {
                    linkedList.addLast(p.left);
                    temp++;
                }
                if(p.right != null) {
                    linkedList.addLast(p.right);
                    temp++;
                }
                i++;
            }
            num = temp;
            result.add(0, list);
        }
        return result;
    }
}