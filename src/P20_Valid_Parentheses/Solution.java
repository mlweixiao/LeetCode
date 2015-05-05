package P20_Valid_Parentheses;

import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
    	LinkedList<Character> sk = new LinkedList<Character>(); 
    	for (int i = 0; i < s.length(); i++) {  
    		if(s.charAt(i)=='(') sk.push('(');
    		else if(s.charAt(i)=='[') sk.push('[');
    		else if(s.charAt(i)=='{') sk.push('{');
    		else if(s.charAt(i)==')'){
    			if(!sk.isEmpty()&&sk.pop()=='(');	
    			else return false;
    		}else if(s.charAt(i)==']'){
    			if(!sk.isEmpty()&&sk.pop()=='[');	
    			else return false;
    		}else if(s.charAt(i)=='}'){
    			if(!sk.isEmpty()&&sk.pop()=='{');	
    			else return false;
    		}	
    	}
    	return sk.isEmpty();
    }
}
