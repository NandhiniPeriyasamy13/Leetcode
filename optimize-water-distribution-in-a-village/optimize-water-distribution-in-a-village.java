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
    
    public DisjointSet(int n){
        this.w = new int[n+1];
        this.p = new int[n+1];
        
        for(int i=0;i<=n;i++){
            this.w[i] = 1;
            this.p[i] = i;
        }
    }
}

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int size = pipes.length;
        int tSize = size+n;
        int[][] graph = new int[tSize][3];
        
        DisjointSet ds = new DisjointSet(n);
        
        for(int i=0;i<pipes.length;i++){
            graph[i][0] = pipes[i][0];
            graph[i][1] = pipes[i][1];
            graph[i][2] = pipes[i][2];
        }
        
        for(int i=0;i<n;i++){
            graph[size][0] = 0;
            graph[size][1] = i+1;
            graph[size++][2] = wells[i];
        }
        
        Arrays.sort(graph, (a,b)-> a[2] - b[2]);
        
        int cost = 0;
        
        for(int i=0;i<graph.length;i++){
            int s = graph[i][0];
            int t = graph[i][1];
            int c = graph[i][2];
            
            if(ds.isSameGroup(s,t))
                continue;
            
            ds.union(s,t);
            cost += c;
        }
        
        return cost;
    }
}