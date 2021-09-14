class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        hs.add('b');
        hs.add('a');
        hs.add('l');
        hs.add('o');
        hs.add('n');
        
        
        int n = text.length();
        
        for(int i=0;i<n;i++){
            char ch = text.charAt(i);
            if(hs.contains(ch)){
                hm.put(ch, hm.getOrDefault(ch,0)+1);
            }
        }
        
        
        if(hm.size() < 5)
            return 0;
        
        int ans = Integer.MAX_VALUE;
        for(char key : hm.keySet()){
            if(key == 'l' || key == 'o'){
                ans = Math.min(ans, hm.get(key)/2);
            }else{
                ans = Math.min(ans, hm.get(key));
            }
        }
        
        return ans;
    }
}