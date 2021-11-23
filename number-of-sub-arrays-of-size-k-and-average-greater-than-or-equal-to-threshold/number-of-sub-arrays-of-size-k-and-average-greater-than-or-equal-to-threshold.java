class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double windowSum = 0.0;
        int windowStart = 0;
        int ans = 0;
        
        for(int windowEnd=0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            
            if(windowEnd >= k-1){
                if(windowSum/k >= threshold)
                    ans++;
                
                windowSum -= arr[windowStart++];
            }
        }
        
        return ans;
    }
}