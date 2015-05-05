package P153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public int findMin_1(int[] num) {
        int  min=Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
        	if(min>num[i])
        		min=num[i];
        }
        return min;
    }
    
    public int findMin(int[] num) {
    	return minFind(num,0,num.length) ;
    }
    private int minFind(int[] num,int begin,int end) {
    	int middle=(begin+end)/2;
    	if(begin==end) return num[begin];
    	else if(end==begin+1) return Math.min(num[begin], num[end]);
    	else if(end==begin+2) return Math.min(Math.min(num[begin], num[begin+1]), num[end]);
    	if(num[middle]<num[begin]&&num[middle]<num[end]){
    		return minFind(num,begin,middle);
    	}
    	else if(num[begin]<num[middle]&&num[end]<num[middle]){
    		return minFind(num,middle,end);
    	}
    	else if(num[begin]<num[middle]&&num[middle]<num[end]){
    		return num[begin];
    	}
    	return 0;
    }
}
