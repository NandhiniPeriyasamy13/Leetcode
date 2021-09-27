class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int n = intervals.length;
        
        for(int i=0;i<n;i++){
            int[] interval = intervals[i];
            pq.add(interval);
        }
        
        List<int[]> result = new ArrayList<>();
        
        while(pq.size() > 1){
            int[] f = pq.poll();
            int[] s = pq.peek();
            
            if(f[1] >= s[0]){
                int[] merge = new int[2];
                merge[0] = f[0];
                merge[1] = Math.max(f[1],s[1]);
                pq.poll();
                pq.add(merge);
            }else{
                result.add(f);
            }
        }
        
        if(pq.size() == 1){
            result.add(pq.poll());
        }
        
        int[][] ans = new int[result.size()][2];
        int i =0;
        for(int[] interval : result){
            ans[i++] = interval;
        }
        
        
        return ans;
    }
}