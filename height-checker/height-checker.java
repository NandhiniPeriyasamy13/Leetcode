class Solution {
    public int heightChecker(int[] heights) {
        int[] exp = Arrays.copyOf(heights, heights.length);
        
        Arrays.sort(exp);
        
        int n = heights.length;
        
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            if(exp[i] != heights[i])
                ans++;
        }
        
        return ans;
    }
}