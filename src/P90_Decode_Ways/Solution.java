package P90_Decode_Ways;

public class Solution {
	public int numDecodings(String s) {
		if(s==null||s.length()==0) return 0;
		
		int f1=1;
		if(s.charAt(0)=='0') f1=0;
		if(s.length()==1 ) return f1;
		
		int f2=2;
		int temp=Integer.parseInt(s.substring(0,2));
		if(temp==10||temp==20) f2=1;
		else if(temp>26&&temp%10!=0) f2=1;
		else if(temp>26&&temp%10==0) f2=0;
		else if(temp<10) f2=0;		 
		if(s.length()==2) return f2;
		
		int f3=0;
		for(int i=2;i<s.length();i++){
		    f3=0;
		    
			if(s.charAt(i)!='0') f3+=f2;
			
			temp=Integer.parseInt(s.substring(i-1,i+1));
			if (9<temp&&temp<27) f3+=f1;
			
			f1=f2;
			f2=f3;
		}
		
		return f3;	
	}
	
}
