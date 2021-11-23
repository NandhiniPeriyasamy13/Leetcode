class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0.0;
        
        int windowStart = 0;
        
        double maxAvg = Double.NEGATIVE_INFINITY;
        
        for(int windowEnd=0;windowEnd < nums.length; windowEnd++){
            windowSum += nums[windowEnd];
            
            if(windowEnd >=k-1){
                maxAvg = Math.max(windowSum/k, maxAvg);
                windowSum -= nums[windowStart++];
            }
        }
        
        return maxAvg;
    }
}