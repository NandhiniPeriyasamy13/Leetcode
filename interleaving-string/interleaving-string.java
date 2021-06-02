class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleaved(s1,s2,s3,s1.length()-1, s2.length()-1, s3.length()-1);
    }
    
    
    private boolean isInterleaved(String s1, String s2, String s3, int m, int n, int k){
        if(m == -1 && n == -1 && k == -1){
            return true;
        }
        
        if(k > -1){
        if(m>-1 && n > -1 && s1.charAt(m) == s3.charAt(k) && s2.charAt(n) == s3.charAt(k))
            return isInterleaved(s1,s2,s3,m-1,n,k-1) || isInterleaved(s1,s2,s3,m,n-1,k-1);
        
        if(m > -1 && s1.charAt(m) == s3.charAt(k))
            return isInterleaved(s1,s2,s3,m-1,n,k-1);
        
        if(n > -1 && s2.charAt(n) == s3.charAt(k))
            return isInterleaved(s1,s2,s3,m,n-1,k-1);
        }
        return false;
    }
}