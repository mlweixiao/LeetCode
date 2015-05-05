package P61_Unique_Paths;

import java.math.BigInteger;

public class Solution {
	public int uniquePaths(int m, int n) {
		BigInteger num = BigInteger.ONE;
		int big = m > n ? m : n;
		int small = m < n ? m : n;
		for (int i = big; i < m + n - 1; i++) {
			num = num.multiply(BigInteger.valueOf(i));
		}

		for (int i = 2; i < small; i++) {
			num = num.divide(BigInteger.valueOf(i));
		}
		return num.intValue();
	}

	public int uniquePaths_2(int m, int n) {
		int[][] grid = new int[m][n];
		int i, j;

		for (i = 0; i < grid.length; i++) {
			grid[i][0] = 1;
		}
		for (i = 1; i < grid[0].length; i++) {
			grid[0][i] = 1;
		}

		for (i = 1; i < grid.length; i++) {
			for (j = 1; j < grid[0].length; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}
		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.uniquePaths(9, 3));
		System.out.println(s.uniquePaths_2(9, 3));
	}
}
