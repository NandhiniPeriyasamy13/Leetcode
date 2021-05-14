class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        
        while(numBottles >= numExchange){
            int ex_bottles = numBottles/numExchange;
            res += ex_bottles;
            numBottles = (numBottles % numExchange) + ex_bottles;
        }
        return res;
    }
}