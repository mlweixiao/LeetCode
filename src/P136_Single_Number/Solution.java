package P136_Single_Number;

public class Solution {
    public int singleNumber(int[] A) {
        int tmp = 0;
        for(int i = 0; i < A.length; i ++) tmp ^= A[i];
        return tmp;
    } 
}