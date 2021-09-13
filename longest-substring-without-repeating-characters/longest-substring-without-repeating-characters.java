class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int n = s.length();
        
        int windowSt = 0;
        
        
        for(int windowEnd=0; windowEnd < n; windowEnd++){
            char ch = s.charAt(windowEnd);
            if(hm.containsKey(ch)){
                windowSt = Math.max(windowSt, hm.get(ch)+1);
            }
            hm.put(ch, windowEnd);      
            len = Math.max(windowEnd-windowSt+1, len);
        }
        return len;
    }
}