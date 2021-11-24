class Solution {
    public int[] sortedSquares(int[] nums) {
        int min = 0;
        
        for(int i=1;i<nums.length;i++){
            min = Math.abs(nums[min]) > Math.abs(nums[i]) ? i : min;
        }
        
        int[] sq = new int[nums.length];
        
        sq[0] = (int)Math.pow(nums[min], 2);
        
        int i = 1;
        int left = min-1;
        int right = min+1;
        
        while(left>=0 && right < nums.length){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                sq[i++] = (int)Math.pow(nums[left--], 2);
            }else{
                sq[i++] = (int)Math.pow(nums[right++], 2);
            }
        }
        
        while(left >= 0){
            sq[i++] = (int)Math.pow(nums[left--],2);
        }
        
        while(right < nums.length){
            sq[i++] = (int)Math.pow(nums[right++],2);
        }
        
        return sq;
        
    }
}