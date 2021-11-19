class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int windowStart = 0;
        int maxLen = 0;

        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
            char ch = s.charAt(windowEnd);

            if(hm.containsKey(ch)){
                windowStart = Math.max(windowStart, hm.get(ch)+1);
            }

            hm.put(ch, windowEnd);

            maxLen = Math.max(windowEnd-windowStart+1, maxLen);
        }

        return maxLen;
    }
}