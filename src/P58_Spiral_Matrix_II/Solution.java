package P58_Spiral_Matrix_II;

public class Solution {
	public int[][] generateMatrix(int n) {
		if (n == 0)
			return new int[0][0];

		int[][] matrix = new int[n][n];
		int x1 = 0;
		int y1 = 0;
		int x2 = matrix.length - 1;
		int y2 = matrix[0].length - 1;
		int i = 0, j = 1;
		while (x1 <= x2 && y1 <= y2) {
			// up row
			for (i = y1; i <= y2; ++i, j++)
				matrix[x1][i] = j;
			// right column
			for (i = x1 + 1; i <= x2; ++i, j++)
				matrix[i][y2] = j;
			// bottom row
			for (i = y2 - 1; x2 != x1 && i >= y1; --i, j++)
				matrix[x2][i] = j;
			// left column
			for (i = x2 - 1; y1 != y2 && i > x1; --i, j++)
				matrix[i][y1] = j;

			x1++;
			y1++;
			x2--;
			y2--;
		}
		return matrix;
	}
}
