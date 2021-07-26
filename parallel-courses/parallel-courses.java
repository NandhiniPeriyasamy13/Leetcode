class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n+1];
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        int total = relations.length;
        
        for(int i=0;i<total;i++){
            int prev = relations[i][0];
            int next = relations[i][1];
            adj.get(prev).add(next);
            indegree[next]++;
        }
        
        int removedEdges = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
            
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i=0;i<size;i++){
                Integer course = q.poll();
                for(Integer prereq : adj.get(course)){
                    indegree[prereq]--;
                    removedEdges++;
                    if(indegree[prereq] == 0){
                        q.add(prereq);
                    }
                }
            }
        }
        
        if(removedEdges != total){
            return -1;
        }
        
        return count;
    }
}