class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> patternMap = new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            patternMap.put(ch, patternMap.getOrDefault(ch,0)+1);
        }
        
        int windowStart = 0;
        int matchedCount = 0;
        
        for(int windowEnd = 0; windowEnd < s2.length(); windowEnd++){
            char rightChar = s2.charAt(windowEnd);
            
            if(patternMap.containsKey(rightChar)){
                patternMap.put(rightChar, patternMap.get(rightChar)-1);
                if(patternMap.get(rightChar) == 0)
                    matchedCount++;
            }
            
            
            if(matchedCount == patternMap.size()){
                return true;
            }
            
            
            
            if(windowEnd >= s1.length()-1){
                char leftChar = s2.charAt(windowStart);
                
                if(patternMap.containsKey(leftChar)){
                    if(patternMap.get(leftChar) == 0)
                        matchedCount--;
                    
                    patternMap.put(leftChar, patternMap.get(leftChar)+1);
                }
                
                windowStart++;
            }
            
        }
        
        return false;
    }
}