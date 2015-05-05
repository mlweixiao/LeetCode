package P120_Triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
		if (triangle == null || triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);

		int[] a = new int[triangle.get(triangle.size() - 1).size()];
		a[0] = triangle.get(0).get(0);

		int[] b = new int[triangle.get(triangle.size() - 1).size()];
		int min = 0;

		for (int i = 1; i < triangle.size(); i++) {
			int j = 0;
			b[0] = a[0] + triangle.get(i).get(0);
			for (j = 1; j < triangle.get(i).size() - 1; j++) {
				min = a[j] < a[j - 1] ? a[j] : a[j - 1];
				b[j] = min + triangle.get(i).get(j);
			}
			b[j] = a[j - 1] + triangle.get(i).get(j);
			
			for (j = 0; j <triangle.get(i).size(); j++) {
				a[j] = b[j];
			}
		}
		
		min = b[0];
		for (int i = 0; i < b.length; i++) {
			min = min < b[i] ? min : b[i];
		}
		return min;
    }
}
