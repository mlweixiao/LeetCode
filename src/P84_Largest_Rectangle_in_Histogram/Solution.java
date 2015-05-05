package P84_Largest_Rectangle_in_Histogram;

public class Solution {
	public int largestRectangleArea(int[] height, int left, int right) {
		if (right < left) {
			return 0;
		}
		int result = 0, leftresult, rightresult, minheight = height[left], minheightindex = left;
		for (int i = left; i <= right; i++) {
			if (height[i] < minheight) {
				minheightindex = i;
				minheight = height[i];
			}
		}
		result = minheight * (right - left + 1);
		leftresult = largestRectangleArea(height, left, minheightindex - 1);
		rightresult = largestRectangleArea(height, minheightindex + 1, right);
		return Math.max(Math.max(leftresult, rightresult), result);
	}

	public int largestRectangleArea_TLE2(int[] height) {
		return largestRectangleArea(height, 0, height.length - 1);
	}

	public int largestRectangleArea_TLE(int[] height) {
		int minheight, result = 0, temp;
		for (int i = 0; i < height.length; i++) {
			minheight = height[i];
			for (int j = i; j < height.length; j++) {
				minheight = height[j] > minheight ? minheight : height[j];
				temp = minheight * (j - i + 1);
				result = result > temp ? result : temp;
			}
		}
		return result;
	}

	public int largestRectangleArea(int[] height) {
		int area = 0;
		for (int i = 0; i < height.length; i++) {
			for (int k = i + 1; k < height.length; k++) {
				if (height[k] < height[k - 1]) {
					i = k - 1;
					break;
				} else {
					i = k;
				}
			}
			int lowest = height[i];
			for (int j = i; j >= 0; j--) {
				if (height[j] < lowest) {
					lowest = height[j];
				}
				int currArea = (i - j + 1) * lowest;
				if (currArea > area) {
					area = currArea;
				}
			}
		}
		return area;
	}

	public static void main(String[] args) {
		Solution S = new Solution();
		int[] height = new int[] { 2, 1, 5, 6, 2, 3 };
		System.out.println(S.largestRectangleArea(height));
	}
}
