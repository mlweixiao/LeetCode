package P16_3Sum_Closest;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		int sum=0,temp,tmp=Integer.MAX_VALUE;
        Arrays.sort(num);
        int n1,n2,n3;
        for(n1=0;n1<num.length-2;n1++){
        	n2=n1+1;
			n3=num.length-1;
			while(n2<n3){
				temp=num[n1]+num[n2]+num[n3]-target;
				temp=Math.abs(temp);
				if(tmp>temp){
					tmp=temp;
					sum=num[n1]+num[n2]+num[n3]-target;
				}
				if(num[n1]+num[n2]+num[n3]==target){
					return target;
				}else if(num[n1]+num[n2]+num[n3]>target){
					n3--;
				}else{
					n2++;
				}
			}
        	while(num[n1]==num[n1+1]&&(n1<(num.length-2))){
        		n1++;
        	}
        }
		return sum+target;
    }
}
