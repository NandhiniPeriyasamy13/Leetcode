class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            Integer room = q.poll();
            
            visited[room] = true;
            
            List<Integer> keys = rooms.get(room);
            
            for(int key : keys){
                if(!visited[key])
                    q.add(key);
            }
            
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i])
                return false;
        }
        
        return true;
    }
}