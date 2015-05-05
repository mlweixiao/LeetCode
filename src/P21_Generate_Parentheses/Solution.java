package P21_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> generateParenthesis(int n) {
		int i, j, k, counter, len;
		String str;
		ArrayList<String> result = new ArrayList<String>();
		if (n < 1)
			return result;
		result.add(new String("("));

		for (i = 1; i < 2 * n; i++) {
			len = result.size();
			for (j = 0; j < len; j++) {
				counter = 0;
				for (k = 0; k < result.get(j).length(); k++) {
					if (result.get(j).charAt(k) == '(')
						counter++;
				}
				if(2 * counter ==result.get(j).length()&&counter<n){
					str = result.get(j) + '(';
					result.set(j, str);
				}
				if (2 * counter > result.get(j).length() && counter < n) {
					str = result.get(j) + '(';
					result.add(str);
					str = result.get(j) + ')';
					result.set(j, str);
				}
				if(counter==n){
					str = result.get(j) + ')';
					result.set(j, str);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.generateParenthesis(3));
	}

}
