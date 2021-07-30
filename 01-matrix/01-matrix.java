class Solution {
    boolean[][] visited;
   public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
       
        Queue<int[]> q = new LinkedList<>();
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
       
        int[][] dir = new int[][]{
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
       while(!q.isEmpty()){
            int size = q.size();
            int[] level = q.poll();
            for(int i=0;i<4;i++){
                int r = level[0];
                int c = level[1];
                int row = r+dir[i][0];
                int col = c+dir[i][1];
                if(row >=0 && col >= 0 && row<m && col<n){
                    if(ans[row][col] > ans[r][c]+1){
                        ans[row][col] = ans[r][c]+1;
                        q.add(new int[]{row,col});
                    }
                }
            }
        }
        return ans;
    }
      
    
    private void addNextLevel(Queue<int[]> q, int i, int j, int m, int n){
        addToQueue(q,i-1,j,m,n);
        addToQueue(q,i+1,j,m,n);
        addToQueue(q,i,j-1,m,n);
        addToQueue(q,i,j+1,m,n);
    }
    
    private void addToQueue(Queue<int[]> q, int i, int j, int m, int n){
        if(i<0||j<0||i>=m || j>=n)
            return;
        if(!visited[i][j]){
            visited[i][j] = true;
            q.add(new int[]{i,j});
        }
    }
}