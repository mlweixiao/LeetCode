package P130_Surrounded_Regions;

//public class Solution {
	  static  int m,n;
	  static  char[][] b;
	    
	    void dfs(int x, int y){
	        if(x<0 || x>=m || y<0 || y>=n || b[x][y]!='O') return;
	        b[x][y]='D';
	        dfs(x-1,y);
	        dfs(x+1,y);
	        dfs(x,y-1);
	        dfs(x,y+1);
	    }
	    
	    public void solve(char[][] board){
	        if(board==null || board.length==0) return;
	        b=board;
	        m=board.length;
	        n=board[0].length;
	        
	        for(int j=0;j<n;j++){
	            dfs(0,j);
	            dfs(m-1,j);
	        }
	        
	        for(int i=1;i<m-1;i++){
	            dfs(i,0);
	            dfs(i,n-1);
	        }
	        
	        for(int i=0;i<m;i++)
	            for(int j=0;j<n;j++){
	                if(b[i][j]=='O') b[i][j]='X';
	                else if(b[i][j]=='D') b[i][j]='O';
	            }  
	}
}