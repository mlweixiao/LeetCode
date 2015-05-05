package P25_Remove_Duplicates_from_Sorted_Array;

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length<1) return 0;
        int i=1;
        int elem=A[0];
        for(int j=1; j<A.length; j++) {
            if(A[j]!=elem) {
                elem=A[j];
                A[i++] = A[j]; 
            }
        }
        return i;
    }
}