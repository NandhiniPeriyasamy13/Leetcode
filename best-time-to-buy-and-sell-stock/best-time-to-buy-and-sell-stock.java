class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        min[0] = 0;
        int minSoFar = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++){
            if(minSoFar < prices[i]){
                min[i] = prices[i] - minSoFar;
                res = Math.max(res, min[i]);
            }else{
                min[i] = 0;
                minSoFar = prices[i];
            }
        }
        return res;
    }
}