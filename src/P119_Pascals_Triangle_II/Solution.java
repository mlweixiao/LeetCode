package P119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> cur = new ArrayList<Integer>();
		cur.add(1);
		if(rowIndex==0) return cur;
		cur.add(1);
		
		List<Integer> pro = cur;
		for (int i = 1; i < rowIndex; i++) {
			cur = new ArrayList<Integer>();
			cur.add(1);

			for (int j = 1; j <= i; j++) {
				int temp = pro.get(j) + pro.get(j - 1);
				cur.add(temp);
			}
			cur.add(1);
			pro = cur;
		}

		return cur;
	}
}
