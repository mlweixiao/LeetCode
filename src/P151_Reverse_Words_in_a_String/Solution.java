package P151_Reverse_Words_in_a_String;

public class Solution {
    public String reverseWords(String s) {
	   String ans=new String(""); 
	   if(s==null) return null;
       String [] temp=s.split(" ");
	   for(int i=temp.length-1;i>=0;i--){
		   if(!temp[i].isEmpty() &&!ans.isEmpty()){
			   ans+=" "+temp[i];
		   }else if(!temp[i].isEmpty()&&ans.isEmpty()){
			   ans+=temp[i];
		   }
	   }
	   return ans;
    }
}
