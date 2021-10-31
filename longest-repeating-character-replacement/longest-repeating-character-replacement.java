class Solution {
    public int characterReplacement(String s, int k) {
        int windowCount = 0;
        int windowStart = 0;
        int maxRepeatChracterCount = 0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int windowEnd = 0;windowEnd < s.length();windowEnd++){
            char curChar = s.charAt(windowEnd);
            hm.put(curChar, hm.getOrDefault(curChar, 0)+1);
            
            maxRepeatChracterCount = Math.max(maxRepeatChracterCount, hm.get(curChar));
            
            int windowSize = windowEnd-windowStart+1;
            
            if(windowSize - maxRepeatChracterCount > k){
                char leftChar = s.charAt(windowStart);
                hm.put(leftChar, hm.get(leftChar)-1);
                windowStart++;
            }
            
            windowCount = Math.max(windowCount, windowEnd-windowStart+1);
        }
        
        return windowCount;
    }
}