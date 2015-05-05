package P32_Search_in_Rotated_Sorted_Array;

public class Solution {
	public int search(int[] A, int target) {
		if(A==null||A.length==0) return -1;
		
		int left=0;
		int right=A.length-1;
		int mid;
		while(left<=right){
			mid=(left+right)/2;
			if(target==A[mid]) return mid;
			
			if(A[mid]<A[right]){
				if(target<=A[right]&&target>A[mid]) left=mid+1;
				else right=mid-1;
			}else{
				if(A[left]<=target&&target<A[mid]) right=mid-1;
				else left=mid+1;
			}
		}
		
		return -1;
	}
}