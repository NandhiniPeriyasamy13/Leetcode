class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],false);
        }
        
        int count = 0;
        for(Integer val: hm.keySet()){
            if(!hm.get(val))
                count = Math.max(count,findGroup(hm,val));
        }
        return count;
    }
    
    private int findGroup(HashMap<Integer,Boolean> hm, int key){
        
        int count = 0;
        if(hm.containsKey(key) && !hm.get(key)){
            count++;
            hm.put(key,true);
            if(hm.containsKey(key-1)){
                count += findGroup(hm, key-1);
            }
            if(hm.containsKey(key+1)){
                count += findGroup(hm,key+1);
            }
        }
        return count;
    }
}