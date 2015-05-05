package P95_Unique_Binary_Search_Trees;

public class Solution {
    public int numTrees(int n) {
        int [] result = new int [n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            for (int k = 0; k < i; k++) {
                tmp += (result[k] * result[i - k - 1]);
            }
            result[i] = tmp;
        }
        return result[n];
    }
}
