package P71_Simplify_Path;

import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
    	String []strs=path.split("/");
    	StringBuilder sb=new StringBuilder("");
    	LinkedList<String> ll=new LinkedList<String>();
    	for(String str:strs){
    		if(str.equals(".")) continue;
    		else if(str.equals("..")&&!ll.isEmpty()) {
    				ll.pollLast();
    		}else if(str.length()>0&&!str.equals("..")){
    			ll.add(str);
    		}
    	}
    	if(ll.isEmpty())return "/";
    	for(String str:ll){
    		sb.append("/");
    		sb.append(str);
    	}
    	return sb.toString();
    }
    
    public static  void main(String []args){
    	String str=new String ("/a/.aa/b");
    	Solution s=new Solution();
    	System.out.println(s.simplifyPath(str));
    }
}
