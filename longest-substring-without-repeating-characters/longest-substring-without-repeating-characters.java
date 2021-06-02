class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int l=0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                l= Math.max(l,hm.get(s.charAt(i))+1);
                ans = Math.max(ans, i-l+1);
            }else{
                ans = Math.max(ans, i-l+1);
            }
            hm.put(s.charAt(i),i);   
        }
        return ans;
    }
}