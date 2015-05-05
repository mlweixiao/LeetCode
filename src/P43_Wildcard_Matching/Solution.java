package P43_Wildcard_Matching;

public class Solution {
	public boolean isMatch(String s, String p) {
		int count = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) != '*') {
				count++;
			}
		}
		if (count > s.length()) {
			return false;
		}
		boolean[][] flag = new boolean[p.length() + 1][s.length() + 1];
		flag[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (flag[i][0] && p.charAt(i) == '*')
				flag[i + 1][0] = true;
			for (int j = 0; j < s.length(); j++) {
				if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
					flag[i + 1][j + 1] = flag[i][j];
				}
				if (p.charAt(i) == '*') {
					flag[i + 1][j + 1] = flag[i + 1][j] || flag[i][j + 1];
				}
			}
		}
		return flag[p.length()][s.length()];
	}

	public static void main(String[] args) {
		Solution S = new Solution();
		String[] str1 = new String[] { "aa", "aa", "aaa", "aa", "aa", "ab",
				"aab", "aab" };
		String[] str2 = new String[] { "a", "aa", "aa", "*", "a*", "?*",
				"c*a*b", "a*" };
		for (int i = 0; i < str1.length; i++)
			System.out.println(S.isMatch(str1[i], str2[i]));
	}
}
