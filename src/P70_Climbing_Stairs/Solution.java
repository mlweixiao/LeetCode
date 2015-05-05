package P70_Climbing_Stairs;

public class Solution {
	public int climbStairs(int n) {
		if (n < 3) return n;
		int f1 = 1;
		int f2 = 2;
		int f3 = 0;
		for (int i = 3; i <= n; i++) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f3;
	}
}
