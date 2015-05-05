package P28_Divide_Two_Integers;

public class Solution {
	public int divide(int dividend, int divisor) {

		boolean positive = true;
		if((dividend>0&&divisor<0)||(dividend<0&&divisor>0))
			positive = false;
		long did=dividend>=0?(long)dividend:-(long)dividend;
		long dis=divisor>=0?(long)divisor:-(long)divisor;

		long quotients = positiveDivide(did, dis);
		if (!positive)
			return (int)-quotients;
		return (int)quotients;
	}
	
	public long positiveDivide(long did, long dis) {
		long sum = 0;
		long quotients = 0;
		if(dis==1) return did;
		
		for (int i = 31; i >= 0; i--) {
			long temp=dis<<i;
			if (sum <= did - temp) {
				sum += temp;
				quotients += 1 << i;
			}
		}		
		return quotients;
	}
}
