class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowCount = 0;
        int windowStart = 0;
        int onesCount = 0;
        
        for(int windowEnd = 0; windowEnd < nums.length;windowEnd++){
            int cur = nums[windowEnd];
            if(cur == 1){
                onesCount++;
            }
            
            int windowSize = windowEnd - windowStart +1;
            
            if(windowSize - onesCount > k){
                int left = nums[windowStart];
                if(left == 1)
                    onesCount--;
                windowStart++;
            }
            
            windowCount = Math.max(windowCount, windowEnd-windowStart+1);
        }
        
        return windowCount;
    }
}