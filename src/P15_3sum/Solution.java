package P15_3sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>>  list = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n1,n2,n3;
        for(n1=0;n1<num.length-2;n1++){
        	n2=n1+1;
			n3=num.length-1;
			while(n2<n3){
				if(num[n1]+num[n2]+num[n3]==0){
					ArrayList<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(num[n1]);
					tmpList.add(num[n2]);
					tmpList.add(num[n3]);
					list.add(tmpList);
					n2++;
					while(num[n2]==num[n2-1]&&n2<n3){
						n2++;
					}
				}else if(num[n1]+num[n2]+num[n3]>0){
					n3--;
				}else{
					n2++;
				}
			}
        	while(num[n1]==num[n1+1]&&(n1<(num.length-2))){
        		n1++;
        	}
        }
		return list;
    }
}
