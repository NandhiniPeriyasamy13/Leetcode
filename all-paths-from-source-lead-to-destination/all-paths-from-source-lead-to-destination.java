class Solution {
    boolean visited[];
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        
        for(int i=0;i<edges.length;i++){
            HashSet<Integer> list = hm.getOrDefault(edges[i][0], new HashSet<>());
            list.add(edges[i][1]);
            hm.put(edges[i][0],list);
        }
        
        if(hm.containsKey(destination))
            return false;
        
        return isDestinationReached(hm, destination, source);
    }
    
    
    private boolean isDestinationReached(HashMap<Integer, HashSet<Integer>> hm, int destination, int v){
        if(v == destination)
            return true;
        
        if(visited[v])
            return false;
        
        if(hm.containsKey(v)){
            visited[v] = true;
            HashSet<Integer> list = hm.get(v);
            for(Integer val : list){
                if(!isDestinationReached(hm,destination, val)){
                    return false;
                }  
            }
            visited[v] = false;
        }else{
            return false;
        }
        
        return true;
    }
}