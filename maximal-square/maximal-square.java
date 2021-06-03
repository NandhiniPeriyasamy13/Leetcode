class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        //base case
        int ans = 0;
        
        for(int i=0;i<m;i++){
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[i][0]);
        }
        
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[0][i]);
        }
        
        
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    if(dp[i-1][j] > 0 && dp[i-1][j-1] > 0 && dp[i][j-1] > 0){
                        int val = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                        dp[i][j] = val+1;
                        
                    }else{
                        dp[i][j] = 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans*ans;
    }
}