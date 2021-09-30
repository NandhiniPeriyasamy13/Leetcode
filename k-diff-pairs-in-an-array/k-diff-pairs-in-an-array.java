class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        
        int ans = 0;
        for(Integer key : hm.keySet()){
            if(k == 0 && hm.get(key) > 1){
                ans++;
            }else if(k>0 && hm.containsKey(k+key))
                ans++;
        }
        return ans;
    }
}