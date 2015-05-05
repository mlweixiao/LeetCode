package P37_Count_and_Say;

public class Solution {
	public String countAndSay(int n) {
		if (n == 0) return "";
		StringBuffer sb = new StringBuffer("1");
		StringBuffer tempSB = new StringBuffer();

		for (int i = 1; i < n; i++) {
			int counter = 1;
			char tempChar = sb.charAt(0);
			for (int j = 1; j < sb.length(); j++) {
				if (sb.charAt(j) == tempChar)
					counter++;
				else {
					tempSB.append(""+counter + tempChar);
					tempChar = sb.charAt(j);
					counter = 1;
				}
			}
			tempSB.append(""+counter + tempChar);
			sb.delete(0, sb.length());
			sb.append(tempSB);
			tempSB.delete(0, tempSB.length());
		}
		return sb.toString();
	}
}
