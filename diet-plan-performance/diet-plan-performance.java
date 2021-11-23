class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        int n = calories.length;
        
        int points = 0;        
        int windowStart = 0;
        
        int windowSum = 0;
        
        for(int windowEnd = 0; windowEnd < n; windowEnd++){
            windowSum += calories[windowEnd];
            
            if(windowEnd >= k-1){
                if(windowSum < lower)
                    points--;
                else if(windowSum > upper)
                    points++;
                
                windowSum -= calories[windowStart++];
            }
        }
        
        return points;
    }
}