class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        
        int sum = 0;
        
        for(int val : hm.values()){
            sum += ap(val-1);
        }
        
        return sum;
    }
    
    private int ap(int n){
        return (n*(n+1))/2;
    }
}