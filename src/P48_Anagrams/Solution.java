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
				if (!result.contains(s))//ĳ���������е�һ�γ��ֵĵ��ʣ�
										//���ǲ�û����ӣ����ڲ���
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
