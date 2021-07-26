class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int removedEdges = 0;
        while(!q.isEmpty()){
            int size = q.size();
            Integer course = q.poll();
            for(Integer prereq : adj.get(course)){
                indegree[prereq]--;
                removedEdges++;
                if(indegree[prereq] == 0){
                    q.add(prereq);
                }
            }
        }
        
        if(removedEdges != prerequisites.length)
            return false;
        return true;
    }
}