class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int windowStart = 0;
        
        int[] ans = new int[nums.length-k+1];
        int i = 0;
        
        for(int windowEnd = 0; windowEnd < nums.length ; windowEnd++){
            int rightNum = nums[windowEnd];
            map.put(rightNum, map.getOrDefault(rightNum,0)+1);
            
            if(windowEnd >= k-1){
                ans[i++] = map.size();
                
                int leftNum = nums[windowStart++];
                map.put(leftNum, map.get(leftNum)-1);
                if(map.get(leftNum) == 0)
                    map.remove(leftNum);
            }
        }
        return ans;
    }
}