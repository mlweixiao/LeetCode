package P93_Restore_IP_Addresses;

import java.util.*;

public class Solution {
	public List<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() < 4 || s == null || s.length() > 12) return result;
		int i, j, k;
		String temp1, temp2, temp3, temp4;
		StringBuffer sb;

		for (i = 1; i < 4; i++) {
			while (s.length() - i > 9) i++;
			temp1 = s.substring(0, i);
			for (j = 1; j < 4 && (i + j) < s.length(); j++) {
				while (s.length() - i - j > 6) j++;
				temp2 = s.substring(i, i + j);
				for (k = 1; k < 4 && (i + j + k) < s.length(); k++) {
					while (s.length() - i - j - k > 3) k++;
					temp3 = s.substring(i + j, i + j + k);
					temp4 = s.substring(i + j + k, s.length());
					if (Integer.parseInt(temp1) < 256
							&& Integer.parseInt(temp2) < 256
							&& Integer.parseInt(temp3) < 256
							&& Integer.parseInt(temp4) < 256
							&& !temp1.matches("0\\d+")
							&& !temp2.matches("0\\d+")
							&& !temp3.matches("0\\d+")
							&& !temp4.matches("0\\d+")) {
						sb = new StringBuffer(s);
						sb.insert(i + j + k, '.');
						sb.insert(i + j, '.');
						sb.insert(i, '.');
						result.add(sb.toString());
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "25525511135";
		Solution s = new Solution();
		List<String> result = s.restoreIpAddresses(str);
		System.out.println(result.toString());
	}

}
