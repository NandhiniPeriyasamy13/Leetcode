class Solution {
    
    HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
    
    public int maximalNetworkRank(int n, int[][] roads) {
        initialize(roads);
        int max = 0;
        
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
                HashSet<Integer> slist = hm.getOrDefault(i, new HashSet<>());
                HashSet<Integer> tlist = hm.getOrDefault(j, new HashSet<>());
               
                int scount = slist.size();
                int dcount = tlist.size();
               
                int count = slist.contains(j) ? scount+dcount-1 : scount+dcount;
            
                max = Math.max(max, count);
           }
       }
            
    
        
        return max;
    }
    
    public void initialize(int [][] roads){
        for(int[] road : roads){
            int s = road[0];
            int t = road[1];
            
            HashSet<Integer> slist = hm.getOrDefault(s, new HashSet<>());
            slist.add(t);
            hm.put(s, slist);
            
            HashSet<Integer> tlist = hm.getOrDefault(t, new HashSet<>());
            tlist.add(s);
            hm.put(t, tlist);
        }
    }
}