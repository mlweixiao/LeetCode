package P100_Same_Tree;

import java.util.Collections;
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
	public boolean isSameTree(TreeNode p, TreeNode q) {
		while (p != null || q != null) {
			if (p == null && q != null)
				return false;
			if (p != null && q == null)
				return false;
			if (p.val == q.val) {
				return isSameTree(p.left, q.left)
						&& isSameTree(p.right, q.right);
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isSameTree_1(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		LinkedList<TreeNode> t1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> t2 = new LinkedList<TreeNode>();
		t1.push(p);
		t2.push(q);
		while (!t1.isEmpty() && !t2.isEmpty()) {
			p = (TreeNode) t1.poll();
			q = (TreeNode) t2.poll();
			if (p == null && q == null)
				continue;
			if (p == null || q == null)
				return false;
			if (p.val != q.val)
				return false;
			Collections.addAll(t1, p.left, p.right);
			Collections.addAll(t2, q.left, q.right);
		}
		if (t1.isEmpty() && t2.isEmpty())
			return true;
		return false;
	}
	
	public boolean isSameTree_2(TreeNode p, TreeNode q) {
		LinkedList<TreeNode> st1=new LinkedList<TreeNode>();
		LinkedList<TreeNode> st2=new LinkedList<TreeNode>();
		st1.push(p);
		st2.push(q);
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;
		while (!st1.isEmpty()&&!st2.isEmpty()){
			 p=(TreeNode) st1.pop();
			 q=(TreeNode) st2.pop();
		     if(p==null && q==null) continue;
		     if(p==null || q==null) return false;
		     if(p.val != q.val) return false;
			 st1.push(p.left);
			 st1.push(p.right);
			 st2.push(q.left);
			 st2.push(q.right);
		}
	    if(st1.isEmpty()&&st2.isEmpty()) return true;
		return false;
	}
}