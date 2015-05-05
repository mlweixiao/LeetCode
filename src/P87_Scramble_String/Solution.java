package P87_Scramble_String;

public class Solution {
	public boolean isScramble_1(String s1, String s2) {
		int n = s1.length();
		boolean[][][] res = new boolean[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					res[0][i][j] = true;
				}
			}
		}

		for (int len = 2; len <= n; len++) {
			for (int i = n - len; i >= 0; i--) {
				for (int j = n - len; j >= 0; j--) {
					boolean r = false;
					for (int k = 1; k < len && !r; k++) {
						r = (res[k - 1][i][j] && res[len - k - 1][i + k][j + k]);
						r = r|| (res[k - 1][i][j + len - k] && res[len - k- 1][i + k][j]);
					}
					res[len - 1][i][j] = r;
				}
			}
		}

		return res[n - 1][0][0];
	}

	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.length() == 0 || s1.equals(s2))
			return true;
		int[] A = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			++A[s1.charAt(i) - 'a'];
			--A[s2.charAt(i) - 'a'];
		}

		for (int i = 0; i < 26; i++) {
			if (A[i] != 0) {
				return false;
			}
		}
		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			}
			if (isScramble(s1.substring(0,i), s2.substring(s2.length() - i))
					&& isScramble(s1.substring(i),
							s2.substring(0, s2.length() - i))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] strs = new String[] { "abcd", "badc" };
		System.out.println(s.isScramble(strs[0], strs[1]));
		System.out.println(s.isScramble_1(strs[0], strs[1]));
	}

}
