package P115_Distinct_Subsequences;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public int numDistinct(String S, String T) {
		int[][] result = new int[T.length() + 1][S.length() + 1];
		for (int i = 1; i <=S.length(); i++) {
			if (T.charAt(0) == S.charAt(i-1)) {
				result[1][i] = result[1][i - 1] + 1;
			} else {
				result[1][i] = result[1][i - 1];
			}
		}
		for (int i = 2; i <= T.length(); i++) {
			for (int j = 1; j <= S.length(); j++) {
				if (T.charAt(i - 1) == S.charAt(j - 1))
					result[i][j] = result[i - 1][j - 1] + result[i][j - 1];
				else
					result[i][j] = result[i][j - 1];
			}
		}

		return result[T.length()][S.length()];
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] S = new String[] {
				"rabbbit",
				"aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe" };
		String[] T = new String[] { "rabbit", "bddabdcae" };
		for (int i = 0; i < S.length; i++)
			System.out.println(s.numDistinct(S[i], T[i]));
	}
}

class Solution_TLE {
	public static int counter = 0;

	public int numDistinct(String S, String T) {
		counter = 0;
		Distinct(S, T);
		return counter;
	}

	public void Distinct(String S, String T) {
		if (T.length() > 0) {
			Pattern p = Pattern.compile(T.substring(0, 1));
			Matcher m = p.matcher(S);
			while (m.find()) {
				Distinct(S.substring(m.start() + 1), T.substring(1));
			}
		} else {
			counter++;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] S = new String[] {
				"rabbbit",
				"aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe" };
		String[] T = new String[] { "rabbit", "bddabdcae" };
		for (int i = 0; i < S.length; i++)
			System.out.println(s.numDistinct(S[i], T[i]));
	}
}
