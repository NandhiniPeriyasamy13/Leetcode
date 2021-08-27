class Solution {
    HashMap<String, LinkedList<String>> adj = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        intializeAdjList(tickets);
        
        dfs("JFK");
        
        return result;
        
    }
    
    
    private void dfs(String origin){
        if(adj.containsKey(origin)){
            LinkedList<String> ts = adj.get(origin);
            while(!ts.isEmpty()){
                String loc = ts.pollFirst();
                dfs(loc);
            }
        }
        result.offerFirst(origin);
    }
    
    private void intializeAdjList(List<List<String>> tickets){
        for(List<String> ticket : tickets){
            String s = ticket.get(0);
            String d = ticket.get(1);
            
            LinkedList<String> ts = adj.getOrDefault(s, new LinkedList<>());
            
            ts.offerLast(d);
            
            adj.put(s,ts);
        }
        
        adj.forEach((key,value) -> Collections.sort(value));
    }
}