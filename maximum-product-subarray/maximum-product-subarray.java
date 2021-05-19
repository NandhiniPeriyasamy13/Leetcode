class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max;
        
        for(int i=1;i<nums.length;i++){
            int temp_max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i], Math.min(max*nums[i], min*nums[i]));
            max = temp_max;
            res = Math.max(max, res);
        }
        return res;
    }
}