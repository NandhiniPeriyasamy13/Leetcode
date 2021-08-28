class Solution {
    
    class DS{
        int[] p;
        int[] w;
        int n;
        
        
        private int find(int a){
            if(a == p[a])
                return a;
            p[a] = find(p[a]);
            
            return p[a];
        }
        
        private void union(int a, int b){
            int roota = find(a);
            int rootb = find(b);
            
            if(w[roota] >= w[rootb]){
                w[roota] += w[rootb];
                p[rootb] = p[roota];
            }else{
                w[rootb] += w[roota];
                p[roota] = p[rootb];
            }
        }
        
        public boolean isSameGroup(int a, int b){
            return find(a) == find(b);
        }
        
        public boolean isGraphConnected(){
            
            for(int i=0;i<this.n;i++){
                find(i);
            }
            
            int pa = p[0];
            for(int i=1;i<this.n;i++){
                if(pa != p[i])
                    return false;
            }
            
            return true;
        }
        
        public DS(int n){
            p = new int[n];
            w = new int[n];
            this.n = n;
            
            for(int i=0;i<n;i++){
                p[i] = i;
                w[i] = 1;
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        DS ds = new DS(n);
        
        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int t = edges[i][1];
            
            if(ds.isSameGroup(s,t))
                return false;
            
            ds.union(s,t);
        }
        
        return ds.isGraphConnected();
        
    }
}