class Solution {
    public int totalMoney(int n) {
        int start = 0;
        int savings = 0;
        int day = 0;
        for(int i=1;i<=n;i++){
            if(i%7 == 1){
                start += 1;
                day = 0;
                savings += start;
            }else{
                savings += start + ++day ;
            }
        }
        return savings;
    }
}