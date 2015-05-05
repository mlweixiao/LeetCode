package P33_Search_for_a_Range;

public class Solution {
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[]{-1,-1};
		int left = 0,right = A.length-1,middle;

		while (left <= right) {
			middle = (left + right) / 2;
			if(A[middle]>target){
				right=middle-1;
			}else if(A[middle]<target){
				left=middle+1;
			}else {
				result[0]=searchLeft(A,left,middle,target);
				result[1]=searchRight(A,middle,right,target);
				return result;
			}
		}
		return result;
	}
	
	private int searchLeft(int[] A,int begin,int end,int target) {
		int left = begin;
		int right = end;
		int middle=(left + right) / 2;

		while (left < right) {
			middle = (left + right) / 2;
			if(A[middle]<target){
				left=middle+1;
			}else {		
				return searchLeft(A,left,middle,target);
			}
		}
		return left;
	}
	private int searchRight(int[] A,int begin,int end,int target) {
		int left = begin;
		int right = end;
		int middle=(left + right) / 2;

		while (left < right) {
			middle = (left + right) / 2;
			if(A[middle]>target){
				right=middle-1;
			}else {
				if(middle==left&&A[right]>target) return left;
				if(middle==left&&A[right]==target) return right;
				return searchRight(A,middle,right,target);
			}
		}
		return left;
	}
}
