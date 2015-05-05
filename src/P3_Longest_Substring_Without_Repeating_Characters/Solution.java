package P3_Longest_Substring_Without_Repeating_Characters;

public class Solution {
	public int lengthOfLongestSubString(String s) {
		StringBuffer best = new StringBuffer();
		StringBuffer temp = new StringBuffer();
		if (s.length() <= 1)
			return s.length();

		for (int i = 0; i < s.length(); i++) {
			if (temp.indexOf(s.substring(i, i + 1)) == -1) {
				temp.append(s.charAt(i));
			} else {
				temp = temp.delete(0, 1 + temp.indexOf(s.substring(i, i + 1)));
				temp.append(s.charAt(i));
			}
			if (best.length() <= temp.length())
				best = new StringBuffer(temp);
		}
		return best.length();
	}
}
