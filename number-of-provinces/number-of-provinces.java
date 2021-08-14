class DisjointSet{
    int[] w;
    int[] p;
    
    public int find(int a){
        if(a == this.p[a])
            return a;
        
        this.p[a] = find(this.p[a]);
        
        return this.p[a];
    }
    
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(this.w[pa] >= this.w[pb]){
            this.p[pb] = this.p[pa];
            this.w[pa] += this.w[pb];
        }else{
            this.p[pa] = this.p[pb];
            this.w[pb] += this.w[pa];
        }
    }
    
    public boolean isSameGroup(int a, int b){
        return find(a) == find(b);
    }
    
    public int findUniqueParents(){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<p.length;i++){
            hs.add(find(this.p[i]));
        }
        
        return hs.size();
    }
    
    public DisjointSet(int n){
        this.w = new int[n];
        this.p = new int[n];
        
        for(int i=0;i<n;i++){
            this.w[i] = 1;
            this.p[i] = i;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j){
                    if(isConnected[i][j]  == 1 && !ds.isSameGroup(i,j)){
                        ds.union(i,j);
                    }
                }
            }
        }
        
        return ds.findUniqueParents();
    }
}