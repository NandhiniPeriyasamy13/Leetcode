class Solution {
    public String reverseWords(String s) {
        StringBuilder sb  = new StringBuilder();
        
        s = s.trim();
        s = s.replaceAll("[ ]+", " ");
        String[] str = s.split(" ");
        int r = str.length -1;
        int l = 0;
        while(l<r){
            String temp = str[r];
            str[r] = str[l];
            str[l] = temp;
            l++;
            r--;
        }
        
        for(int i=0;i<str.length;i++){
            sb.append(str[i]).append(" ");
        }
        
        return sb.toString().trim();
    }
}