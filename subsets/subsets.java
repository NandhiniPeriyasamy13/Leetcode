class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new ArrayList<>());
        return ans;
    }
    
    
    private void subsets(int[] nums, int index, List<Integer> list){
        if(index > nums.length)
            return;
        
        ans.add(new ArrayList<>(list));
        
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            subsets(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}