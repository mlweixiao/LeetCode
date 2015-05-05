package P155_Min_Stack;

import java.util.Stack;

public  class MinStack {
	 private Stack<Integer> stack=new Stack<Integer>();
	 private Stack<Integer> min=new Stack<Integer>();
    public void push(int x) {
       stack.push(x); 
       if(min.isEmpty()||x<=min.peek()){
    	   min.push(x);
       }   
    }

    public void pop() {
        if(min.peek().equals(stack.peek())){
        	min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
