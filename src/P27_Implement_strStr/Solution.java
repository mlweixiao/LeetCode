package P27_Implement_strStr;

public class Solution {
    public String strStr_easy(String haystack, String needle) {
    	int i=haystack.indexOf(needle);
    	if(i==-1) return null;  
       return haystack.substring(i);   
    }
    
    public String strStr_KMP(String haystack, String needle) {
    	int i=haystack.indexOf(needle);
    	if(i==-1) return null;  
       return haystack.substring(i);   
    }
    
    public String strStr_BM(String haystack, String needle) {
    	int i=haystack.indexOf(needle);
    	if(i==-1) return null;  
       return haystack.substring(i);   
    }
    
    public String strStr_Sunday(String haystack, String needle) {
    	int i=haystack.indexOf(needle);
    	//if(i==-1) return null;  
       //return haystack.substring(i);   
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
