class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineFreq = new int[26];
        
        for(int i=0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            magazineFreq[ch-'a']++;
        }
        
        for(int i=0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            magazineFreq[ch-'a']--;
            if(magazineFreq[ch-'a'] < 0)
                return false;
        }
        
        return true;
    }
}