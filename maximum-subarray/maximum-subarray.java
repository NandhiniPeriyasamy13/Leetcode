class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int[] temp = new int[n];
        temp[0] = nums[0];
        
        int ans = temp[0];
        
        for(int i=1;i<n;i++){
            temp[i] = Math.max(temp[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, temp[i]);
        }
        
       return ans; 
    }
}