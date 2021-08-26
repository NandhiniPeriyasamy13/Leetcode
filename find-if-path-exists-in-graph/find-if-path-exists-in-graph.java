class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end)
            return true;
        
        HashMap<Integer, List<Integer>> hm = getAdjList(edges);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        
        boolean[] visited = new boolean[n];
        
        while(!q.isEmpty()){
            Integer s = q.poll() ;
            visited[s] = true;
            
            if(hm.containsKey(s)){
            for(Integer t : hm.get(s)){
                if(t == end)
                    return true;
                if(!visited[t]){
                    q.add(t);
                }
            }
            }
            
        }
        
        return false;
    }
    
    private HashMap<Integer, List<Integer>> getAdjList(int[][] edges){
        int n = edges.length;
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int t = edges[i][1];
            
            List<Integer> sList = hm.getOrDefault(s, new ArrayList<>());
            List<Integer> tList = hm.getOrDefault(t, new ArrayList<>());
            
            sList.add(t);
            tList.add(s);
            
            hm.put(s, sList);
            hm.put(t, tList);
        }
        
        return hm;
    }
}