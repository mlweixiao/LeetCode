package P49_Pow;

//LeetCode, Pow(x, n)
//���ַ���$x^n = x^{n/2} * x^{n/2} * x^{n\%2}$
//ʱ�临�Ӷ�O(logn)���ռ临�Ӷ�O(1)

public class Solution {
	public double pow(double x, int n) {
		if (n < 0)
			return 1.0 / power(x, -n);
		else
			return power(x, n);
	}

	private double power(double x, int n) {
		if (n == 0)
			return 1;
		double v = power(x, n / 2);
		if (n % 2 == 0)
			return v * v;
		else
			return v * v * x;
	}
};
