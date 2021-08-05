class Solution {
    public String longestPalindrome(String s) {
        
        int max = 1;
        int n = s.length();
        String ans = s.charAt(0)+"";
        int start = 0;
        int end= 1;
        
        for(int i=0;i<n;i++){
            
            //Odd palindromes
            int j = i-1;
            int k = i+1;
            while(j>=0 && k<n){
                if(s.charAt(j) == s.charAt(k)){
                    if(max < k-j+1){
                        max = k-j;
                        start = j;
                        end = k+1;
                    }
                    j--;
                    k++;
                }else{
                    break;
                }
            }
            
            //Even palindromes
            j = i-1;
            k = i;
            while(j>=0&& k<n){
                if(s.charAt(j) == s.charAt(k)){
                    if(max < k-j+1){
                        max = k-j;
                        start = j;
                        end = k+1;
                    }
                    j--;
                    k++;
                }else{
                    break;
                }
            }
        }
        
        ans = s.substring(start,end);
        
        return ans;
    }
}