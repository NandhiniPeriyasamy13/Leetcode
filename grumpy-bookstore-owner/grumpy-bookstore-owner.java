class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i] == 0){
                ans+= customers[i];
            }
        }
        
        //Add initial sliding window period
        int i=0;
        int period = 0;
        int max_period = 0;
        
        while(i<minutes){
            if(grumpy[i] == 1){
                period += customers[i];
                max_period = period;
            }
            i++;
        }
        
        int j = 0;
        
        for(i=minutes ; i<grumpy.length; i++){
            if(grumpy[j] == 1){
                period -= customers[j];
            }
            if(grumpy[i] == 1){
                period += customers[i];
            }
            j++;
            max_period = Math.max(max_period, period);
        }
        
        return ans + max_period;
    }
}