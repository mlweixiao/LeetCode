package P69_Sqrt;

public class Solution {
	public int sqrt(int x) {
		if (x < 2)
			return x;
		int begin = 1;
		int end = (int) (x >> 1);
		int mid, last_mid = 0;
		while (begin <= end) {
			mid = (begin + end) >> 1;
			if (x / mid > mid) {
				begin = mid + 1;
				last_mid = mid;
			} else if (x / mid < mid) {
				end = mid - 1;
			} else
				return mid;
		}
		return last_mid;
	}
}
