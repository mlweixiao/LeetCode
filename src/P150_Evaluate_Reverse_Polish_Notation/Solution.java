package P150_Evaluate_Reverse_Polish_Notation;

import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
    	int num1,num2,temp;
    	LinkedList<Integer> sk=new LinkedList<Integer>();
        for(String str:tokens){
        	if(str.equals("+")){
        		num1=sk.pop();
        		num2=sk.pop();
        		temp=num2+num1;
        		sk.push(temp);
        	}else if(str.equals("-")){
        		num1=sk.pop();
        		num2=sk.pop();
        		temp=num2-num1;
        		sk.push(temp);
        	}else if(str.equals("/")){
        		num1=sk.pop();
        		num2=sk.pop();
        		temp=num2/num1;
        		sk.push(temp);
        	}else if(str.equals("*")){
        		num1=sk.pop();
        		num2=sk.pop();
        		temp=num2*num1;
        		sk.push(temp);
        	}else{
        		temp=Integer.parseInt(str);
        		sk.push(temp);
        	}
        }
        return sk.pop();
    }
}
