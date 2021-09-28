class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        
        int  i = 0;
        
        int start = n/2;
        while(start>0){
            ans[i++] = start;
            ans[i++] = -start;
            start--;
        }
        
        if(n%2 != 0)
            ans[i] = 0;
        
        return ans;
    }
}