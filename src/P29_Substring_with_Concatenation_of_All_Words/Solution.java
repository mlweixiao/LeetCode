package P29_Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = L.length * L[0].length();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (hm.containsKey(L[i])) {
				int value = hm.get(L[i]);
				value++;
				hm.put(L[i], value);
			} else {
				hm.put(L[i], 1);
			}
		}

		HashSet<Integer> forbidden = new HashSet<Integer>();
		for (int i = 0; i <= S.length() - L[0].length() * L.length; i++) {
			if (forbidden.contains(i))
				continue;

			HashMap<String, Integer> hashmap = new HashMap<String, Integer>(hm);
			String str = S.substring(i + len - L[0].length(), i + len);
			if (result.contains(i - L[0].length())) {
				String temp = S.substring(i - L[0].length(), i);
				if (temp.contains(str)) {
					result.add(i);
				}
			} else {
				boolean flag = true;
				for (int j = 0; j < len; j += L[0].length()) {
					str = S.substring(i + j, i + j + L[0].length());
					if (!hashmap.containsKey(str)) {
						for (int k = i + L[0].length(); k <= i + j; k += L[0]
								.length()) {
							forbidden.add(k);
						}
						flag = false;
						break;
					} else if (hashmap.get(str) == 0) {
						flag = false;
						break;
					} else {
						int value = hashmap.get(str);
						value--;
						hashmap.put(str, value);
					}
				}
				if (flag)
					result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String S = new String("acccaccaa");
		String[] L = new String[] { "aa", "cc", "ca" };
		System.out.println(s.findSubstring(S, L));
	}
}
