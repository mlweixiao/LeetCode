package P8_String_to_Integer;

public class Solution {
    public int atoi(String str) {
    	int i=0;
    	int ans=0;
    	long tmp=0;
    	boolean flag=true;
    	if(str==null||str.length()<1) return 0;
    	while (str.charAt(i) == ' ' && i < str.length()){
    		i++;
    	}
    	if (str.charAt(i) == '+'){
    		i++;	
    	}
    	else if (str.charAt(i) == '-') {
    		flag=false;
    		i++;
    	}
    	for(;i<str.length();i++){
    		if(str.charAt(i)<='9'&&'0'<=str.charAt(i)){
    			tmp=tmp*10+(str.charAt(i)-'0');
    			if(flag&&tmp>Integer.MAX_VALUE){
    				return Integer.MAX_VALUE;
    			}
    			else if(!flag&&-tmp<Integer.MIN_VALUE){
    				return Integer.MIN_VALUE;
    			}
    		}else{
    			break;
    		}	
    	}
    	if(!flag){
    		ans=(int) -tmp;
    	}else{
    		ans=(int) tmp;
    	}
    	return ans;    
    }
}
