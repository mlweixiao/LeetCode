package P103_Binary_Tree_Zigzag_Level_Order_Traversal;

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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		boolean flag = false;
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
                if(!flag) {
                	list.add(p.val);
                }else{
                	list.add(0,p.val);
                }
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
            flag=!flag;
            num = temp;
            result.add(list);
        }
        return result;
    }
}