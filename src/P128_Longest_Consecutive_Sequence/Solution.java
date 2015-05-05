package P128_Longest_Consecutive_Sequence;

import java.util.Arrays;

public class Solution {
    public int longestConsecutive(int[] num) {
    	if(num.length==0||num.length==0) return num.length;
    	Arrays.sort(num); 
    	int max=1;
    	int temp=1;
    	for(int i=1;i<num.length;i++){
    		if(num[i]-1==num[i-1]) temp++;
    		else if (num[i]==num[i-1])  continue;
    		else temp=1;
    		if(temp>max) max=temp;
    	}
    	return max;
    }
}
