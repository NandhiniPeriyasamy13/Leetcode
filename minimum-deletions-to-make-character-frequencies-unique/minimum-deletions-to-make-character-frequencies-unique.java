class Solution {
    public int minDeletions(String s) {
        //compute frequency
        
        int[] freq = new int[26];
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        
        // insert freq into heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                pq.add(freq[i]);
            }
        }
        
        
        // core logic
        int count = 0;
        
        while(pq.size() > 1){
            int f = pq.poll();
            int sec = pq.peek();
            
            if(f == sec){
                pq.poll();
                if(pq.size() > 0){
                    int t = pq.peek();
                    if(f == t){
                        pq.add(f);
                    }
                }
                sec--;
                count++;
                if(sec != 0){
                    pq.add(sec);
                }
            }
            
        }
        
        return count;
    }
}