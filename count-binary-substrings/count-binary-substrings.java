class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int cur = 1;
        int sum = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) != s.charAt(i)){
                sum += Math.min(prev,cur);
                prev = cur;
                cur = 1;
            }else{
                cur++;
            }
        }
        
        return sum + Math.min(prev,cur);
    }
}