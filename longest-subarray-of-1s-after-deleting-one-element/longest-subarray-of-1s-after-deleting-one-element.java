class Solution {
    public int longestSubarray(int[] nums) {
        int windowStart = 0;
        int maxLen = 0;
        
        int oneLen = 0;
        
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            if(nums[windowEnd] == 1)
                oneLen++;
            
            int windowSize = windowEnd- windowStart+1;
            
            while(windowSize-oneLen > 1){
                int leftNum = nums[windowStart++];
                if(leftNum == 1)
                    oneLen--;
                
                windowSize = windowEnd- windowStart +1;
            }
            
            if(windowSize - oneLen == 1){
                maxLen = Math.max(maxLen, oneLen);
            }
            
            if(windowSize - oneLen == 0){
                maxLen = Math.max(maxLen, oneLen-1);
            }
            
        }
        
        return maxLen;
    }
}