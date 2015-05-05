package P14_Longest_Common_Prefix;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		int minLength = Integer.MAX_VALUE;
		StringBuffer common = new StringBuffer("");

		for (int i = 0; i < strs.length; i++) {
			if (minLength > strs[i].length())
				minLength = strs[i].length();
		}

		for (int i = 0; i < minLength; i++) {
			char temp = strs[0].charAt(i);
			int j = 0;
			for (; j < strs.length && temp == strs[j].charAt(i); j++);
			if (j == strs.length)
				common.append(temp);
			else
				break;
		}

		return common.toString();
	}
	
}
