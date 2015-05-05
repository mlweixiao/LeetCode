package P2_Median_of_Two_Sorted_Arrays;

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		int i = 0, j = 0, m = A.length, n = B.length;
		double ans;
		int[] temp = new int[m + n];

		if (m == 0&&n % 2 == 0) 
				return (B[n >> 1] + B[(n >> 1) - 1]) / 2.0;
		else if(m == 0&&n % 2 != 0)
				return B[n >> 1];
		
		if (n == 0&&m % 2 == 0) 
				return (A[m >> 1] + A[(m >> 1) - 1]) / 2.0;
		else if  (n == 0&&m % 2 != 0)
				return A[m >> 1];
		
		while ((i + j) <= ((m + n) >> 1)) {
			if (i < m && j < n) {
				if (A[i] < B[j]) {
					temp[i + j] = A[i];
					i++;
				} else {
					temp[i + j] = B[j];
					j++;
				}
			} else if (i == m && j < n) {
				temp[i + j] = B[j];
				j++;
			} else if (i < m && j == n) {
				temp[i + j] = A[i];
				i++;
			}
		}
		if ((m + n) % 2 == 0)
			ans = (temp[(m + n) >> 1] + temp[((m + n) >> 1) - 1]) / 2.0;
		else
			ans = temp[(m + n) >> 1];
		return ans;
	}
}
