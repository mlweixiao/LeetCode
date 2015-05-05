package P57_Length_of_Last_Word;

public class Solution {
    public int lengthOfLastWord(String s) {
        String [] temp=s.split(" ");
        if(temp.length==0) return 0; 
        if(temp[temp.length-1].isEmpty()) return 0;
        return temp[temp.length-1].length();
    }
}
