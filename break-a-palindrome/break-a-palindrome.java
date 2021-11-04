class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1)
            return "";
        
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0;i<palindrome.length()/2;i++){
            char ch = palindrome.charAt(i);
            if(ch != 'a'){
                sb.append(palindrome.substring(0,i));
                sb.append("a");
                sb.append(palindrome.substring(i+1));
                return sb.toString();
            }
        }
        
        
        sb.append(palindrome.substring(0, palindrome.length()-1));
        sb.append("b");
    
        
        return sb.toString();
    }
}