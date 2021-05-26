class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=0;i<nums.length;i++){
            if(dp[i] > 0){
                int val = nums[i];
                for(int j=i+1; j<=i+val ;j++){
                    if(j < nums.length){
                        dp[j]++;
                    }
                }
            }
        }
        return dp[nums.length-1] > 0 ? true : false;
    }
    
    
}