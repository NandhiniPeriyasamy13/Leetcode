class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int n = edges.length;
        
        for(int i=0;i<n;i++){
            int s = edges[i][0];
            int t = edges[i][1];
            hm.put(s, hm.getOrDefault(s, 0)+1);
            hm.put(t, hm.getOrDefault(t, 0)+1);
        }
        
        int nodes = hm.size();
        
        for(Integer s : hm.keySet()){
            if(hm.get(s) == nodes-1)
                return s;
        }
        
        return -1;
    }
}