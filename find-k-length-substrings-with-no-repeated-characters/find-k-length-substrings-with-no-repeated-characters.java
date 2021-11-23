class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int ans = 0;
        int windowStart = 0;
        Set<Character> set = new HashSet<>();
        
        for(int windowEnd =0 ; windowEnd <s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            while(set.contains(rightChar)){
                char leftChar = s.charAt(windowStart++);
                set.remove(leftChar);
            }
            
            set.add(rightChar);
            
            int windowSize = windowEnd - windowStart +1;
            
            ans += windowSize >= k ? 1 : 0;
        }
        
        return ans;
    }
}