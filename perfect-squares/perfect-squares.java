class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        list.add(1);
        
        for(int i=2;i<=n;i++){
            if(i*i <= n){
                dp[i*i] = 1;
            }
            if(dp[i] == 1){
                list.add(i);
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int val : list){
                min = Math.min(min, 1+dp[i-val]);
            }
            dp[i] = min;
        
            
        }
        
        return dp[n];
    }
}