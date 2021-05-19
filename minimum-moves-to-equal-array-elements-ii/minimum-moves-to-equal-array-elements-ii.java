class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = 0;
        if(nums.length%2 == 0){
            median = (nums[nums.length/2] + nums[(nums.length/2)-1])/2;
        }else{
            median = nums[nums.length/2];
        }
        
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res += Math.abs(nums[i] - median);
        }
        return res;
    }
}