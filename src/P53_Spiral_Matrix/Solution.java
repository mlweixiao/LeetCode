package P53_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (matrix.length == 0)
			return al;
		int x1 = 0;
		int y1 = 0;
		int x2 = matrix.length - 1;
		int y2 = matrix[0].length - 1;
		while (x1 <= x2 && y1 <= y2) {
			// up row
			for (int i = y1; i <= y2; ++i)
				al.add(matrix[x1][i]);
			// right column
			for (int i = x1 + 1; i <= x2; ++i)
				al.add(matrix[i][y2]);
			// bottom row
			for (int i = y2 - 1; x2 != x1 && i >= y1; --i)
				al.add(matrix[x2][i]);
			// left column
			for (int i = x2 - 1; y1 != y2 && i > x1; --i)
				al.add(matrix[i][y1]);

			x1++;
			y1++;
			x2--;
			y2--;
		}

		return al;
	}
}
