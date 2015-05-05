package P74_Search_a_2D_Matrix;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		int row = matrix.length;
		int column = matrix[0].length;

		int left = 0;
		int right = row * column-1;
		int mid;
		int temp;
		
		while (left <= right) {
			mid = (left + right) >> 1;
			temp = matrix[mid / column][mid % column];
			if (target == temp) return true;
			else if (target > temp) left = mid + 1;
			else right = mid - 1;
		}
		
		return false;
	}
}
