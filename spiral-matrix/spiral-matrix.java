class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int t = 0;
        int l = 0;
        int r = m-1;
        int b = n-1;
        
        List<Integer> ans = new ArrayList<>();
        
        while(ans.size() < n*m){
            
            for(int i=l;i<=r;i++){
                ans.add(matrix[t][i]);
            }

            
            for(int i=t+1;i<=b;i++){
                ans.add(matrix[i][r]);
            }
            
  
            
            if(t != b){
                for(int i=r-1;i>=l;i--){
                    ans.add(matrix[b][i]);
                }
            }
            
            
            
            if(l != r){
                for(int i=b-1;i>t;i--){
                    ans.add(matrix[i][l]);
                }
            }
            t++;
            b--;
            r--;
            l++;
        }
        return ans;
    }
}