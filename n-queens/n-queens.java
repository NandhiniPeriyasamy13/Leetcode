class Solution {
       char[][] board;
        List<List<String>> ans;
        int n;

        public List<List<String>> solveNQueens(int n) {
            board = new char[n][n];
            ans = new ArrayList<>();
            this.n = n;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    board[i][j] = '.';
                }
            }

            solveQueens(0);

            return ans;
        }


        private void solveQueens(int row){
            if(row == n){
                if(isSolved()){
                    addBoard();
                }
                return;
            }

            if(isConflictingBoard()){
                return;
            }

            //Main Idea
            for(int j=0;j<n;j++){
                    if(board[row][j] == '.'){
                        board[row][j] = 'Q';
                        solveQueens(row+1);
                        board[row][j] = '.';
                    }
                }
        }


        private boolean isConflictingBoard(){
            // check 1 queen per row
            for(int i=0;i<n;i++){
                int nqueens = 0;
                for(int j=0;j<n;j++){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return true;
                    }
                }
            }


            //check 1 queen per column
            for(int i=0;i<n;i++){
                int nqueens = 0;
                for(int j=0;j<n;j++){
                    if(board[j][i] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return true;
                    }
                }
            }

            //check diagonally
            int row = 0;
            while(row < n){
                int i=row;
                int j = 0;
                int nqueens = 0;
                while(i>=0){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return true;
                    }
                    i--;
                    j++;
                }
                row++;
            }

            //lower diagonal
            int col = 0;
            while(col < n){
                int i = n-1;
                int j = col;
                int nqueens = 0;
                while(j <n){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return true;
                    }
                    i--;
                    j++;
                }
                col++;
            }

            //lower diagonal
            col = 0;
            while(col < n){
                int i = 0;
                int j = col;
                int nqueens = 0;
                while(j<n){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return true;
                    }
                    i++;
                    j++;
                }
                col++;
            }

            row = 0;
            while(row < n){
                int i = row;
                int j = 0;
                int nqueens = 0;
                while(i<n){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return true;
                    }
                    i++;
                    j++;
                }
                row++;
            }


            return false;
        }

        private boolean isSolved(){

            // check 1 queen per row
            for(int i=0;i<n;i++){
                int nqueens = 0;
                for(int j=0;j<n;j++){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return false;
                    }
                }
                if(nqueens == 0)
                    return false;
            }


            //check 1 queen per column
            for(int i=0;i<n;i++){
                int nqueens = 0;
                for(int j=0;j<n;j++){
                    if(board[j][i] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return false;
                    }
                }
                if(nqueens == 0)
                    return false;
            }


            // check diagonally
            //upper left diagonal
            //upper left diagonal
            int row = 0;
            while(row < n){
                int i=row;
                int j = 0;
                int nqueens = 0;
                while(i>=0){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return false;
                    }
                    i--;
                    j++;
                }
                row++;
            }

            //lower diagonal
            int col = 0;
            while(col < n){
                int i = n-1;
                int j = col;
                int nqueens = 0;
                while(j<n){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return false;
                    }
                    i--;
                    j++;
                }
                col++;
            }

            //lower diagonal
            col = 0;
            while(col < n){
                int i = 0;
                int j = col;
                int nqueens = 0;
                while(j<n){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return false;
                    }
                    i++;
                    j++;
                }
                col++;
            }

            row = 0;
            while(row < n){
                int i = row;
                int j = 0;
                int nqueens = 0;
                while(i<n){
                    if(board[i][j] == 'Q'){
                        nqueens++;
                    }
                    if(nqueens > 1){
                        return false;
                    }
                    i++;
                    j++;
                }
                row++;
            }


            return true;
        }

        private void addBoard(){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            ans.add(list);
        }
}