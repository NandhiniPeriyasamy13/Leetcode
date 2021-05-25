class Solution {
    public int arrangeCoins(int n) {
        int ans = 0;
        int i = 0;
        while(n>0){
            i++;
            n -= i;
            if(n<0){
                break;
            }
            ans++;
        }
        return ans;
    }
}