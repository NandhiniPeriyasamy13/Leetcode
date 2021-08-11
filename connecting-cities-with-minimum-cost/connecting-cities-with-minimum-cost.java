class DisjointSet{
    int[] w;
    int[] p;
    
    
    public int find(int a){
        if(a == this.p[a])
            return a;
        
        this.p[a] = find(this.p[a]);
        a = this.p[a];             
        
        return this.p[a];
    }
    
    public boolean isSameSet(int a , int b){
        return find(a) == find(b);
    }
    
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(w[pa] >= w[pb]){
            this.p[pb] = pa;
            this.w[pa] += this.w[pb];
        }else{
            this.p[pa] = pb;
            this.w[pa] += this.w[pb];
        }
    }
    
    
    public DisjointSet(int n){
        this.w = new int[n+1];
        this.p = new int[n+1];
        
        for(int i=1;i<=n;i++){
            this.w[i] = 1;
            this.p[i] = i;
        }
    }
}

class Solution {  
    public int minimumCost(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        Arrays.sort(connections, (a,b) -> a[2] - b[2]);
        
        int cost = 0;
        int total = 0;
        
        for(int i=0;i<connections.length;i++){
            int s = connections[i][0];
            int t = connections[i][1];
            int c = connections[i][2];
            
            if(ds.isSameSet(s,t))
                continue;
            
            cost += c;
            ds.union(s,t);
            total++;
        }
        
        if(total == n-1)
            return cost;
        
        return -1;
    }
}