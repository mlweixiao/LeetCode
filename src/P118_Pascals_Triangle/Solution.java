package P118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> list=new ArrayList<List<Integer>>();
       List<Integer> arraylist=new ArrayList<Integer>();
       
       if(numRows==0) return list;
       arraylist.add(1);
       list.add(arraylist);
       
       for(int i=1;i<numRows;i++){
    	   List<Integer> pro=list.get(list.size()-1);
    	   List<Integer> cur=new ArrayList<Integer>();
    	   cur.add(1);
    	   
    	   for(int j=1;j<i;j++){
    		   int temp=pro.get(j)+pro.get(j-1);
    		   cur.add(temp);
    	   }
    	   cur.add(1);
    	   list.add(cur);
       }
       
       return list;
    }
}
