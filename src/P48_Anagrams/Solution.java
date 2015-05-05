package P48_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String, String> hm = new HashMap<String, String>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			if (!hm.containsKey(String.valueOf(c))) {
				hm.put(String.valueOf(c), str);
			} else {
				String s = hm.get(String.valueOf(c));
				if (!result.contains(s))//某个回文序列第一次出现的单词，
										//我们并没有添加，现在补上
					result.add(s);
				result.add(str);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] strs = new String[] { "abc", "bca", "bac", "bbb", "bbca",
				"abcb" };
		System.out.println(s.anagrams(strs));
	}
}
