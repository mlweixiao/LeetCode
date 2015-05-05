package P17_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	ArrayList<List<Integer>>  result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int n1,n2,n3,n4;
        for(n1=0;n1<num.length-3&&num[n1]<=target/4;n1++){
            for(n2=n1+1;n2<num.length-2;n2++){
            	n3=n2+1;
    			n4=num.length-1;
    			while(n3<n4){
    				if(num[n1]+num[n2]+num[n3]+num[n4]==target){
    					ArrayList<Integer> tmplist = new ArrayList<Integer>();
    					tmplist.addAll(Arrays.asList(num[n1],num[n2],num[n3],num[n4]));
    					result.add(tmplist);
    					n3++;
    					while(num[n3]==num[n3-1]&&n3<n4) n3++;
    				}else if(num[n1]+num[n2]+num[n3]+num[n4]>target) n4--;
    				else n3++;
    			}
            	while(num[n2]==num[n2+1]&&(n2<(num.length-2))) n2++; 	
            }
            while(num[n1]==num[n1+1]&&n1<num.length-3) n1++; 
        }
		return result; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int [] a=new int[] {0,0,0,0};
		int target=0;
		System.out.println(s.fourSum(a, target));
	}

}
