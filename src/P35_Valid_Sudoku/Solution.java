package P35_Valid_Sudoku;

public class Solution {
	   public boolean isValidSudoku(char[][] board) {
	    	int [] count=new int [10];
	    	int i;
	    	int j;
	    	for(i=0;i<9;i++){
	    		for(j=0;j<9;j++){
	    			if(board[i][j]!='.'){
	    				count[board[i][j]-'0']++;
	    			}	
	    		}
	    		for(j=0;j<10;j++){
	    			if(count[j]>1){ 
	    				return false;
	    			}
	    			count[j]=0;
	    		}
	    	}
	    	
	    	for(i=0;i<9;i++){
	    		for(j=0;j<9;j++){
	    			if(board[j][i]!='.'){
	    				count[board[j][i]-'0']++;
	    			}	
	    		}
	    		for(j=0;j<10;j++){
	    			if(count[j]>1){ 
	    				return false;
	    			}
	    			count[j]=0;
	    		}
	    	}
	    	for(i=0;i<3;i++){
	    		for(j=0;j<3;j++){
	    			for(int m=0;m<9;m++){
	    				char temp=board[3*i+m/3][3*j+m%3];
	    				if(temp!='.')
	    					count[temp-'0']++;
	    			}
	        		for(int m=0;m<10;m++){
	        			if(count[m]>1){ 
	        				return false;
	        			}
	        			count[m]=0;
	        		}
	    		}
	    	}
	    	
	    	return true;        
	    }
	}
