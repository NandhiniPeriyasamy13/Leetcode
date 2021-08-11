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
            this.p[pb] = pa;
            this.w[pa] += this.w[pb];
        }else{
            this.p[pa] = pb;
            this.w[pb] += this.w[pa];
        }
    }
    
    public boolean isSameSet(int a , int b){
        return find(a) == find(b);
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
    public int minCostConnectPoints(int[][] points) {
        List<int[]> connections = new ArrayList<>();
        
        int n = points.length;
        
        for(int i=0;i<n-1;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int[] connection = new int[3];
                connection[0] = i;
                connection[1] = j;
                connection[2] = Math.abs(x2-x1) + Math.abs(y2-y1);
                connections.add(connection);
            }
        }
        
        n = connections.size();
        
        Collections.sort(connections, (a,b) -> a[2] - b[2]);
        
        DisjointSet ds = new DisjointSet(n);
        
        int cost = 0;
        for(int i=0;i<n;i++){
            int[] connection = connections.get(i);
            int s = connection[0];
            int t = connection[1];
            int c = connection[2];
            
            if(ds.isSameSet(s,t))
                continue;
            
            cost += c;
            ds.union(s,t);
        }
        
        return cost;
        
    }
}