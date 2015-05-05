package P62_Unique_Paths_II;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] grid = new int[m][n];
		int i, j;
		boolean flag = false;

		for (i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				flag = true;
			if (!flag)
				grid[i][0] = 1;
		}

		flag = false;
		for (i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1)
				flag = true;
			if (!flag)
				grid[0][i] = 1;
		}

		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0)
					grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}
		return grid[m - 1][n - 1];
	}
	
	public static void main(String []args){
		Solution s=new Solution();
		int [][]b=new int [][]{{1,0}};
		System.out.println(s.uniquePathsWithObstacles(b));
		
	}
}
