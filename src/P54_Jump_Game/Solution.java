package P54_Jump_Game;

public class Solution {
    public boolean canJump_time_out(int[] A) {
    	if(A.length==1) return true;
    	boolean [] flag =new boolean[A.length];
    	for(int i=0;i<A.length;i++){
    		for(int j=1;j<=A[i]&&(i+j)<A.length;j++){
    			if(flag[i]) flag[i+j]=true;
    		}
    	}
    	return flag[A.length-1];
    }
    
    public boolean canJump(int[] A) { 	
    	if(A.length==1) return true;
    	for(int i=0;i<A.length;){
    		if(A[i]>0)  i+=A[i];
    		else {
    			int j=i-1;
    			for(;j>=0;j--){
    				if(j+A[j]>i){
    					i=j+A[j];
    					break;
    				}
    			}
    			if(j<0) return false;
    		}
    		if(i+1>=A.length) return true;
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A=new int []{2,0};
		Solution s=new  Solution();
		System.out.println(s.canJump(A));	
	}

}
