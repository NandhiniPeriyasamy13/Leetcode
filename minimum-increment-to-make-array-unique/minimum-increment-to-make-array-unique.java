class Solution {
    public int minIncrementForUnique(int[] nums) {
        int[] count = new int[45000];
        for(int val : nums){
            count[val]++;
        }
        
        int taken = 0;
        int ans = 0;
        
        for(int i=0;i<45000;i++){
            if(count[i]>=2){
                taken += count[i]-1;
                ans -= i*(count[i] -1);
            }else if(taken > 0 && count[i] == 0){
                taken--;
                ans += i;
            }
        }
        return ans;
    }
}