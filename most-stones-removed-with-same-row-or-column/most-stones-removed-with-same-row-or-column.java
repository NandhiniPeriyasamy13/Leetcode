class Solution {
    class DS{
        int[] p;
        int[] w;
        int count = 0;
        
        private int find(int a){
            if(a == p[a])
                return a;
            
            p[a] = find(p[a]);
            
            return p[a];
        }
        
        public void union(int a , int b){
            int roota = find(a);
            int rootb = find(b);
            if(roota != rootb){
                if(w[roota] >= w[rootb]){
                    w[roota] += w[rootb];
                    p[rootb] = roota;
                }else{
                    w[rootb] += w[roota];
                    p[roota] = rootb;
                }
                count--;
            }
        }
        
        
        public DS(int n){
            p = new int[n];
            w = new int[n];
            count = n;
            for(int i=0;i<n;i++){
                p[i] = i;
                w[i] = i;
            }
        }
    }
    
    
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        
        DS ds = new DS(n);
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int[] s1 = stones[i];
                int[] s2 = stones[j];
                if(s1[0] == s2[0] || s1[1] == s2[1]){
                    ds.union(i,j);
                }
            }
        }
        
        return n - ds.count;
    }
}