package P40_First_Missing_Positive;

import java.util.Arrays;

public class Solution {
	public int firstMissingPositive(int[] A) {
		int i = 0, n = A.length, temp;
		while (i < n) {
			if (A[i] != (i + 1) && A[i] >= 1 && A[i] <= n
					&& A[A[i] - 1] != A[i]) {
				temp = A[i];
				A[i] = A[A[i] - 1];
				A[A[i] - 1] = temp;
			} else
				i++;
		}
		for (i = 0; i < n; ++i)
			if (A[i] != (i + 1))
				return i + 1;
		return n + 1;
	}
	 
	public 	int firstMissingPositive_2(int A[]) {
		Arrays.sort(A);
		int res = 0,i=0,n=A.length;
		while (i<n && A[i]<=0) i++;
		for (; i < n; i++)
		{//注意：一看到序列就应该马上反应问题：是否有重复元素？？？
			if (i>0 && A[i] == A[i-1]) continue;
			if (A[i] - res != 1) return res+1;
			else res = A[i];
		}
		return res+1;
	}
}
