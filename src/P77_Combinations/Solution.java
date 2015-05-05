package P77_Combinations;

import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        ArrayList<Integer> al=new ArrayList<Integer>();
        boolean [] flag= new boolean [n];
        int i,j,temp,p;
        int sub =n-k;
        
        for(i=0;i<k;i++){
        	flag[i]=true;
        	al.add(i+1);
        }
        result.add(al);
        
        for(;;){
        	temp=0;
        	for(j=0;j<n-1;j++){
        		if(!flag[j]) temp++;
        		if(flag[j]&&!flag[j+1]){
        			flag[j]=false;
        			flag[j+1]=true;
        			break;
        		}
        	}
        	if(temp==sub) break;
        	for(p=0;p<j-temp;p++) flag[p]=true;
        	
        	for(p=0;p<temp;p++) flag[j-temp+p]=false;
        	
        	al=new ArrayList<Integer>();
        	for(j=0;j<n;j++){
        		if(flag[j]) al.add(j+1);    			
        	}
        	result.add(al);
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		List<List<Integer>> result=s.combine(5, 3);
		System.out.println(result.toString());
		System.out.println(result.size());
	}

}
