class Solution {
    
    boolean[] visited;
    
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        
        visited = new boolean[n];
        
        int count = 0;
        for(int i=0;i<n;i++){
            
            if(!visited[i]){
                count = Math.max(count, dfs(nums, i));
            }
        }
        
        return count;
    }
    
    private int dfs(int[] nums, int index){
        int ans = 0;
        
        if(!visited[index]){
            visited[index] = true;
            
            int next = nums[index];
            ans += dfs(nums, next);
            ++ans;
        }
        
        
        return ans;
    }
}