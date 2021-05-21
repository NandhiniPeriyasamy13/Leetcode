class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] < nums[i]){
                continue;
            }else{
                res += Math.abs(nums[i]-nums[i-1]) +1;
                nums[i] += Math.abs(nums[i]-nums[i-1]) +1;
            }
        }
        return res;
    }
}