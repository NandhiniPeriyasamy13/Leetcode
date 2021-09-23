class Solution {
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[n][m];
                    boolean isWordFound =  exist(board, word, 0, i,j);
                    if(isWordFound){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
    private boolean exist(char[][] board, String word, int windex, int i, int j){
        
        if(word.length() == windex)
            return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || word.charAt(windex) != board[i][j])
            return false;
        
    
        visited[i][j] = true;
        
        boolean isWordFound = false;
        for(int k=0;k<4;k++){
            
            isWordFound = exist(board, word, windex+1, i+dirs[k][0], j+dirs[k][1]);
            
            if(isWordFound){
                break;
            }
        }
        
        visited[i][j] = false;
        return isWordFound;
    }
}