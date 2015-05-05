package P65_Add_Binary;

public class Solution {
	public String addBinary(String a, String b) {
		int len1 = a.length() - 1;
		int len2 = b.length() - 1;
		int len = len1 > len2 ? len1 : len2;
		StringBuffer aa = new StringBuffer(a);
		StringBuffer bb = new StringBuffer(b);
		if (len1 > len2) {
			bb.append("0", 0, len1 - len2);
//			for (int i = 0; i < len1 - len2; i++)
//				bb.insert(0, '0');
		} else if (len1 < len2) {
			aa.append("0", 0, len2- len1);
//			for (int i = 0; i < len2 - len1; i++)
//				aa.insert(0, '0');
		}

		int flag = 0;
		StringBuffer ans = new StringBuffer("");
		int temp = 0;

		while (len > 0) {
			temp = (aa.charAt(len) - '0') + (bb.charAt(len) - '0') + flag;
			if (temp >= 2)
				flag = 1;
			else
				flag = 0;
			temp = temp % 2;
			ans.insert(0, (char) ('0' + temp));
			len--;
		}
		temp = (aa.charAt(len) - '0') + (bb.charAt(len) - '0') + flag;
		ans.insert(0, (char)(temp % 2 + '0'));

		if (temp >= 2)
			ans.insert(0, '1');
		return ans.toString();
	}
	
	public static void main(String []args){
		Solution s=new Solution();
		String str1=new String("11");
		String str2=new String("1");
		System.out.println(s.addBinary(str1, str2));
	}
}
