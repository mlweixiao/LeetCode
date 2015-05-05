package P34_Search_Insert_Position;

public class Solution {
    public int searchInsert(int[] A, int target) {
    	int high=A.length-1;
    	int low=0;
    	int middle=(high+low)/2;
    	while(low<=high){
        	if(target==A[middle]) return middle;
        	else if(A[middle]<target){
        		low=middle+1;
        	}
        	else{
        		high=middle-1;
        	}
        	middle=(high+low)/2;
    	}
        return low;
    }
}
