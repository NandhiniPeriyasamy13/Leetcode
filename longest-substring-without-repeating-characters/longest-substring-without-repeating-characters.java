class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowCount = 0;
        int windowStart = 0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int windowEnd =0;windowEnd<s.length();windowEnd++){
            char ch = s.charAt(windowEnd);
            if(hm.containsKey(ch)){
                windowStart = Math.max(windowStart,hm.get(ch)+1);
            }
            hm.put(ch, windowEnd);
            
            windowCount = Math.max(windowCount, windowEnd-windowStart+1);
        }
        return windowCount;
    }
}