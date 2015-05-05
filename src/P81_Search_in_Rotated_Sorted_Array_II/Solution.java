package P81_Search_in_Rotated_Sorted_Array_II;

public class Solution {
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0)
			return false;

		int left = 0;
		int right = A.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (target == A[mid])
				return true;

			if (A[mid] < A[right]) {
				if (target <= A[right] && target > A[mid])
					left = mid + 1;
				else
					right = mid - 1;
			} else if(A[mid] > A[right]){
				if (A[left] <= target && target < A[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}else{
				while(left<=right){
					if(A[left]==target) return true;
					left++;
				}
				left++;
			}
		}
		return false;
	}

}