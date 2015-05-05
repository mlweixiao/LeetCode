package P42_Multiply_Strings;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {
        BigInteger n1=new BigInteger(num1);
        BigInteger n2=new BigInteger(num2);
        return String.valueOf(n1.multiply(n2));
    }
    
    public String multiply_2(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
    	char [] temp=new char [num1.length()+num2.length()];
    	Arrays.fill(temp,'0');   	
    	StringBuilder sb=new StringBuilder(String.valueOf(temp));
    
    	for(int i=num1.length()-1;i>=0;i--){
			int carry=0;
			int a=num1.charAt(i)-'0';
    		for(int j=num2.length()-1;j>=0;j--){
    			int b=num2.charAt(j)-'0';
    			int value=carry+a*b+(sb.charAt(i+j+1)-'0');
    			carry=value/10;
    			value%=10;
    			sb.setCharAt(1+i+j, (char)(value+'0'));
    		}
    		sb.setCharAt(i, (char)(carry+'0'));
    	}
    	return sb.charAt(0)=='0'?sb.substring(1):sb.toString();
    }
    
    
    public static void main(String []args){
    	Solution s=new Solution();
    	String num1=new String ("16346457568568");
    	String num2=new String("0");
        System.out.println(s.multiply(num1, num2));
        System.out.println(s.multiply_2(num1, num2));
    }
}
