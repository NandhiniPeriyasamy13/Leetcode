class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int windowStart = 0;
        int windowCount = 0;
        
        for(int windowEnd = 0; windowEnd<s.length();windowEnd++){
            char ch = s.charAt(windowEnd);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            
            while(hm.size() > k){
                char startChar = s.charAt(windowStart);
                hm.put(startChar, hm.get(startChar)-1);
                windowStart++;
                
                if(hm.get(startChar) == 0)
                    hm.remove(startChar);
            }
            
            
            windowCount = Math.max(windowCount, windowEnd-windowStart+1);
        }
        
        return windowCount;
    }
}