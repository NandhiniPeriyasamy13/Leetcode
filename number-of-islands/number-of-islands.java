class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    islands++;
                    findLands(grid, i, j);
                }
            }
        }
        
        return islands;
    }
    
    private void findLands(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        findLands(grid,i+1,j);
        findLands(grid,i,j-1);
        findLands(grid,i,j+1);
        findLands(grid,i-1,j);
    }
}