package P41_Trapping_Rain_Water;

public class Solution {
	public int trap(int[] A) {
		int result = 0, temp;
		int[] leftmax = new int[A.length];
		int[] rightmax = new int[A.length];
		for (int i = 0, max = -1; i < A.length; i++) {
			leftmax[i] = max;
			max = max > A[i] ? max : A[i];
		}
		for (int i = A.length - 1, max = -1; 0 <= i; i--) {
			rightmax[i] = max;
			max = max > A[i] ? max : A[i];
		}
		for (int i = 1; i < A.length - 1; i++) {
			temp = Math.min(leftmax[i], rightmax[i]);
			if (temp > A[i]) {
				result += temp - A[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution S = new Solution();
		int[] A = new int[] { 0, 1 };
		System.out.println(S.trap(A));
	}
}
