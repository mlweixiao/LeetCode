package P97_Interleaving_String;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		int i, j;
		boolean[][] flag = new boolean[s1.length() + 1][s2.length() + 1];
		flag[0][0] = true;

		for (i = 1; i <= s1.length()&&s3.startsWith(s1.substring(0, i)); flag[i][0] = true,i++) ;
		for (i = 1; i <= s2.length()&&s3.startsWith(s2.substring(0, i)); flag[0][i] = true,i++) ;

		for (i = 1; i <= s1.length(); i++) {
			for (j = 1; j <= s2.length(); j++) {
				if (flag[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j + i - 1))
					flag[i][j] = true;
				else if (flag[i - 1][j]&& s1.charAt(i - 1) == s3.charAt(j + i - 1))
					flag[i][j] = true;
			}
		}

		return flag[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String ss1 = "aabcc";
		String ss2 = "dbbca";
		String ss4 = "aadbbcbcac";

		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.out.println(s.isInterleave(s1, s2, s3));
		System.out.println(s.isInterleave(ss1, ss2, ss4));
	}
}
