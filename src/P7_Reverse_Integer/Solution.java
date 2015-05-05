package P7_Reverse_Integer;

public class Solution {
    public int reverse(int x) {
        int nReverse = 0;
        while (x != 0) {
            nReverse = nReverse * 10 + x % 10;
            x = x / 10;
        }
        return nReverse; 
    }
}
