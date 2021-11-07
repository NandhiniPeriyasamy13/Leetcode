class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        
        int windowStart = 0;
        int windowEnd = 0; 
        while(windowEnd<s2.length()){
            char ch = s2.charAt(windowEnd);
            
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(ch) == 0)
                    hm.remove(ch);
                
                if(hm.size() == 0)
                    return true;
            windowEnd++;
            }else{
                char ch1 = s2.charAt(windowStart);
                    hm.put(ch1, hm.getOrDefault(ch1,0)+1);
                    windowStart++;
            }
            
        }
        
        return false;
    }
}