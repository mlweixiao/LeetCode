package P125_Valid_Palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
    	int tmp ='A'-'a';
    	int i=0;
    	int j=s.length()-1;
    	while(i<=j){
    		while(i<s.length()){
        		if('a'<=s.charAt(i)&&s.charAt(i)<='z') break;
        		else if('A'<=s.charAt(i)&&s.charAt(i)<='Z') break;
        		else if('0'<=s.charAt(i)&&s.charAt(i)<='9') break;
        		else i++;
    		}
    		while(0<=j){
        		if('a'<=s.charAt(j)&&s.charAt(j)<='z') break;
        		else if('A'<=s.charAt(j)&&s.charAt(j)<='Z') break;
        		else if('0'<=s.charAt(j)&&s.charAt(j)<='9') break;
        		else j--;
    		}
    		if(i==s.length()) return true;
    		if(s.charAt(i)==s.charAt(j)){
    			i++;
    			j--;
    		}
    		else if(tmp+s.charAt(i)==s.charAt(j)){
    			i++;
    			j--;
    		}
    		else if(s.charAt(i)-tmp==s.charAt(j)){
    			i++;
    			j--;
    		}
    		else return false; 
    	}
        return true;
    }
}
