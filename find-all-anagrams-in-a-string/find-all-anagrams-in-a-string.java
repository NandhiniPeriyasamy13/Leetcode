class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        
        int windowStart = 0;
        List<Integer> ans = new ArrayList<>();
        
        int matched = 0;
        
        for(int windowEnd =0; windowEnd<s.length(); windowEnd++){
            char ch = s.charAt(windowEnd);
            
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(ch) == 0)
                    matched++;
            }
            
            if(matched == hm.size()){
                ans.add(windowStart);
            }
            
            if(windowEnd >= p.length() -1){
                char leftChar = s.charAt(windowStart);
                if(hm.containsKey(leftChar)){
                    if(hm.get(leftChar) == 0){
                        matched--;
                    }
                    hm.put(leftChar, hm.get(leftChar)+1);
                }
                windowStart++;
            }
            
        }
        return ans;   
    }
}