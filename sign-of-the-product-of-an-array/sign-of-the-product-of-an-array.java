class Solution {
    public int arraySign(int[] nums) {
        int n = nums.length;
        
        int negCount = 0;
        
        for(int i=0;i<n;i++){
            if(nums[i] == 0)
                return 0;
            if(nums[i] < 0)
                negCount++;
        }
        
        return negCount%2 == 0 ? 1 : -1;
    }
}