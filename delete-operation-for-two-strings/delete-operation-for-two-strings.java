class Solution {
    int[][] dp ;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return editDistance(word1,word2,word1.length(),word2.length());
    }
    
    public int editDistance(String word1, String word2, int m , int n){
        if(m == 0){
            return n;
        }
        if(n ==0){
            return m;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return dp[m][n] = editDistance(word1,word2,m-1,n-1);
        }
        
        return dp[m][n] = 1+Math.min(editDistance(word1,word2,m-1,n),
                          editDistance(word1,word2,m,n-1));
    }
}