class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        dp = new int[s1.length()][s2.length()];
        
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return isInterleaved(s1,s2,s3, 0, 0,0);
    }
    
    
    private boolean isInterleaved(String s1, String s2, String s3, int m, int n, int k)     {
        if(m == s1.length())
            return s2.substring(n).equals(s3.substring(k));
        
        if(n == s2.length())
            return s1.substring(m).equals(s3.substring(k));
        
        if(dp[m][n] != -1)
            return dp[m][n] == 1 ? true : false;
        
        boolean ans = false;
        
        if(m < s1.length() && s1.charAt(m) == s3.charAt(k))
            ans |= isInterleaved(s1,s2,s3,m+1,n,k+1);
        
        if(n < s2.length() && s2.charAt(n) == s3.charAt(k))
            ans |= isInterleaved(s1,s2,s3,m,n+1,k+1);
        
        dp[m][n] = ans ? 1:0;
        return ans;
    }
}