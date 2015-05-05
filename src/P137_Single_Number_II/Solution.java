package P137_Single_Number_II;

public class Solution {
    public int singleNumber(int[] A) {
    	int result=0;
        int [] flag=new int[32];
        for(int i=0;i<A.length;i++){
        	for(int j=0;j<32;j++) flag[j]+=((A[i]>>j)%2);
        }
        for(int i=0;i<32;i++){
        	if (flag[i]%3!=0) result+=1<<i;
        }
        return result;
    }
}