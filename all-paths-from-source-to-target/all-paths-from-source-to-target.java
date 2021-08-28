class Solution {
    
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    
    List<List<Integer>> allPaths = new ArrayList<>();
    
    int last = 0 ;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        last = graph.length;
        initAdjList(graph);
        dfs(0, new ArrayList<>());
        return allPaths;
    }
    
    public void dfs(int node, List<Integer> path){
        path.add(node);
        if(node == last-1) {
            allPaths.add(new ArrayList<>(path));
        }
        if(adj.containsKey(node)){
            List<Integer> list = adj.get(node);
            for(int s : list){
                dfs(s, path);
            }
            
        }
        path.remove(path.size()-1);
    }
    
    private void initAdjList(int[][] graph){
        int n = graph.length;
        for(int i=0;i<n;i++){
            int[] edges = graph[i];
            if(edges.length > 0){
                List<Integer> list = new ArrayList<>();
                for(int edge : edges){
                    list.add(edge);
                }
                adj.put(i,list);
            }
        }
    }
}