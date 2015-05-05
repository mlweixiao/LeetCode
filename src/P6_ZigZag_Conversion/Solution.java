package P6_ZigZag_Conversion;

public class Solution {
	public String convert(String s, int nRows) {
		if (nRows == 1 || s.length() == 0)
			return s;
		boolean flag = false;// 标记生产字符的方向

		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < nRows; i++)
			sb[i] = new StringBuffer("");

		for (int i = 0, j = 0; i < s.length(); i++) {
			sb[j].append(s.charAt(i));
			if (j == nRows - 1)
				flag = true;
			else if (j == 0)
				flag = false;
			if (!flag)
				j++;
			else
				j--;
		}

		for (int i = 1; i < nRows; i++)
			sb[0].append(sb[i]);

		return sb[0].toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "PAYPALISHIRING";
		int nRows = 1;
		Solution s = new Solution();
		System.out.println(s.convert(str, nRows));
		System.out.println("PAHNAPLSIIGYIR");
	}

}
