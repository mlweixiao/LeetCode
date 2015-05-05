package P47_Rotate_Image;

public class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int i = 0, j = n - 1;
		for (; i < j; i++, j--) {
			int forward = i, backward = j;
			while (forward < j) {
				int t = matrix[i][forward];
				matrix[i][forward] = matrix[backward][i];
				matrix[backward][i] = matrix[j][backward];
				matrix[j][backward] = matrix[forward][j];
				matrix[forward][j] = t;
				forward++;
				backward--;
			}
		}
	}
}
