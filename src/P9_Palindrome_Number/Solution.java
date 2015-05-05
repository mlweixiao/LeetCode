package P9_Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x) {
    	int tmpInt=x;
        long  tmp=0;
        while(x>0){
            tmp=tmp*10+x%10;
            x=x/10;   
        }
        return tmpInt==tmp;
        
    }
}
