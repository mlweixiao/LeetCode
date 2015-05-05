package P68_Text_Justification;

import java.util.*;

public class Solution {
	public List<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		String str = new String("");
		int i, j;
		for (i = 0; i < L; i++) {
			str += " ";
		}

		StringBuffer sb = new StringBuffer("");
		for (i = 0, j = 1; i < words.length; i++) {
			if (sb.length() == 0) {
				sb.append(words[i]);
				j = 1;
			} else if (sb.length() + 1 + words[i].length() == L) {
				sb.append(" " + words[i]);
				result.add(sb.toString());
				sb = new StringBuffer("");
			} else if (sb.length() + 1 + words[i].length() < L) {
				sb.append(" " + words[i]);
				j++;
			} else if ((sb.length() < L && j > 1)) {
				int n = (L - sb.length()) / (j - 1);
				int m = (L - sb.length()) % (j - 1);
				int len = sb.length();
				for (int k = 1; k < j; k++) {
					len -= (words[i - k].length() + 1);
					if (m + k >= j)
						sb.insert(len, str.substring(0, n + 1));
					else
						sb.insert(len, str.substring(0, n));
				}
				result.add(sb.toString());
				sb = new StringBuffer(words[i]);
				j = 1;
			} else if (sb.length() <= L && j == 1) {
				sb.append(str.substring(0, L - sb.length()));
				result.add(sb.toString());
				sb = new StringBuffer(words[i]);
			}
		}
		if (sb.length() < L) {
			sb.append(str.substring(0, L - sb.length()));
		}
		result.add(sb.toString());
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] str = new String[] { "Don't", "go", "around", "saying", "the",
				"world", "owes", "you", "a", "living;", "the", "world", "owes",
				"you", "nothing;", "it", "was", "here", "first." };
		int l = 30;
		List<String> result = s.fullJustify(str, l);
//		for (String ss : result) {
//			System.out.println(ss);
//		}
		System.out.println(result.toString());

	}
}
