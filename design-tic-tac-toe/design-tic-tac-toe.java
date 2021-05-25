class TicTacToe {
    int[][] board;
    HashMap<Integer,HashSet<Integer>> col = new HashMap<>();
    HashMap<Integer,HashSet<Integer>> row = new HashMap<>();
    HashMap<Integer,HashSet<Integer>> diagonal = new HashMap<>();
    HashMap<Integer,HashSet<Integer>> antiDiagonal = new HashMap<>();
    int player1Moves = 0;
    int player2Moves = 0;
    int n ;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        HashSet<Integer> rowSet = this.row.getOrDefault(player, new HashSet<>());
        rowSet.add(row);
        
        HashSet<Integer> colSet = this.col.getOrDefault(player, new HashSet<>());
        colSet.add(col);
        
        HashSet<Integer> diagonalSet = this.diagonal.getOrDefault(player, new HashSet<>());
        diagonalSet.add(row-col);
        
        HashSet<Integer> antiDiagonalSet = this.antiDiagonal.getOrDefault(player, new HashSet<>());
        antiDiagonalSet.add(row+col);
        
        
        this.row.put(player, rowSet);
        this.col.put(player, colSet);
        this.diagonal.put(player,diagonalSet);
        this.antiDiagonal.put(player,antiDiagonalSet);
        
        if(player == 1){
            player1Moves++;
        }else{
            player2Moves++;
        }
        
        if((player == 1 && player1Moves >= n) || (player == 2 && player2Moves >= n)){
            return isSolved(player,row,col);
        }
        
        return 0;
    }
    
    private int isSolved(int player, int row, int col){
        int player2 = player == 1 ? 2 : 1;
        HashSet<Integer> rowSet = this.row.getOrDefault(player2, new HashSet<>());
        HashSet<Integer> colSet = this.col.getOrDefault(player2, new HashSet<>());
        HashSet<Integer> diagonalSet = this.diagonal.getOrDefault(player2, new HashSet<>());
        HashSet<Integer> antiDiagonalSet = this.antiDiagonal.getOrDefault(player2, new HashSet<>());

        boolean flag = true;
        if(!rowSet.contains(row)){
            for(int i=0;i<n;i++){
                if(board[row][i] != player){
                    flag = false;
                    break;
                }
            }
        }else{
            flag = false;
        }
        
        if(flag){
            return player;
        }
        
        flag = true;
        
        if(!colSet.contains(col)){
            for(int i=0;i<n;i++){
                if(board[i][col] != player){
                    flag = false;
                    break;
                }
            }
        }else{
            flag = false;
        }
        
        if(flag){
            return player;
        }
        
        flag = true;
        
        if(!diagonalSet.contains(row-col)){
            int i = row;
            int j = col;
            int count = 0;
            while(i>=0 && j>=0){
                if(board[i][j] != player){
                    flag = false;
                    break;
                }
                count++;
                i--;
                j--;
            }
            
            i = row;
            j = col;
            while(i<n && j<n){
                if(board[i][j] != player){
                    flag = false;
                    break;
                }
                i++;
                j++;
                count++;
            }
            
            
            if(count-1 != n){
                flag = false;
            }
        }else{
            flag = false;
        }
        
       if(flag){
            return player;
        }
        
        flag = true;
        
        if(!antiDiagonalSet.contains(row+col)){
            int i = row;
            int j = col;
            int count = 0;
            while(i>=0 && j<n){
                if(board[i][j] != player){
                    flag = false;
                    break;
                }
                count++;
                i--;
                j++;
            }
            
            i = row;
            j = col;
            while(i<n && j>=0){
                if(board[i][j] != player){
                    flag = false;
                    break;
                }
                count++;
                i++;
                j--;
            }
            if(count-1 != n){
                flag = false;
            }
        }else{
            flag = false;
        }
        

        if(flag){
            return player;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */