class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        
        int first = 0;
        int sec = 1;
        
        while(sec < nums.length){
            while(sec < nums.length && nums[first] == nums[sec]){
                sec++;
            }
            
            if(sec < nums.length){
                first++;
                nums[first] = nums[sec];
                sec++;
            }
        }
        
        return first+1;
    }
}