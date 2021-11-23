class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int windowStart = 0;
        
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            int rightNum = nums[windowEnd];
            map.put(rightNum, map.getOrDefault(rightNum,0)+1);
            
            if(map.get(rightNum) > 1)
                return true;
            
            if(windowEnd >= k){
                int leftNum = nums[windowStart++];
                map.put(leftNum, map.get(leftNum)-1);
            }
        }
        
        return false;
    }
}