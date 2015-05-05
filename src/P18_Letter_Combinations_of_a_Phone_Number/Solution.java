package P18_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

class A {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		String[] string = new String[] { " ", "", "abc", "def", "ghi", "jkl",
				"mno", "pqrs", "tuv", "wxyz" };
		result.add(new String(""));
		int i,j,k,len,tmp;
		for(i=0;i<digits.length();i++){
			len=result.size();
			tmp = (int) (digits.charAt(i) - '0');
			for (j = 0; j < string[tmp].length() - 1; j++) {
				for (k = 0; k < len; k++) {
					result.add(new String(result.get(k)));
				}
			}
			for (j = 0; j < result.size(); j++) {
				k = j / len;
				String str = result.get(j) + string[tmp].charAt(k);
				result.set(j, str);
			}
		}
		return result;
	}
}

public class Solution {
	List<String> result = new ArrayList<String>();
	String[] string = new String[] { " ", "", "abc", "def", "ghi", "jkl",
			"mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		result.add(new String(""));
		if (digits.length() == 0)
			return result;
		letterOfCombinations(digits);
		return result;
	}

	public void letterOfCombinations(String digits) {
		int tmp = (int) (digits.charAt(0) - '0');
		int len = result.size();
		int i, j;
		for (i = 0; i < string[tmp].length() - 1; i++) {
			for (j = 0; j < len; j++) {
				result.add(new String(result.get(j)));
			}
		}
		for (i = 0; i < result.size(); i++) {
			j = i / len;
			String str = result.get(i) + string[tmp].charAt(j);
			result.set(i, str);
		}
		if (digits.length() == 1)
			return;
		letterOfCombinations(digits.substring(1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("23");
		A a=new A();
		//Solution s = new Solution();

		System.out.println(a.letterCombinations(str).toString());
	}

}
