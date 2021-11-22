class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> patternMap = new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            patternMap.put(ch, patternMap.getOrDefault(ch,0)+1);
        }
        
        int windowStart = 0;
        int matchedCount = 0;
        int minLen = Integer.MAX_VALUE;
        int optWinStart = 0;
        
        for(int windowEnd =0;windowEnd<s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            if(patternMap.containsKey(rightChar)){
                patternMap.put(rightChar, patternMap.get(rightChar)-1);
                
                if(patternMap.get(rightChar) >= 0){
                    matchedCount++;
                }
            }
            
            //shrink the window
            
            while(matchedCount == t.length()){
                int windowSize = windowEnd - windowStart +1;
                if(minLen > windowSize){
                    minLen = windowSize;
                    optWinStart = windowStart;
                }
               
                
                char leftChar = s.charAt(windowStart);
                
                if(patternMap.containsKey(leftChar)){
                    if(patternMap.get(leftChar) >=0){
                        matchedCount--;
                    }
                    
                    patternMap.put(leftChar, patternMap.get(leftChar)+1);
                }
                
                windowStart++;
                
                
            }
              
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(optWinStart, optWinStart+minLen);
    }
}