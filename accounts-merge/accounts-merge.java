class Solution {
    class DS{
        int[] p;
        int[] w;
        int count = 0;
        int n = 0;
        
        
        public int find(int a){
            if(a == p[a])
                return a;
            
            p[a] = find(p[a]);
            
            return p[a];
        }
        
        public void union(int a, int b){
            int roota = find(a);
            int rootb = find(b);
            
            if(roota != rootb){
            if(w[roota] >= w[rootb]){
                w[roota] += w[rootb];
                p[rootb] = p[roota]; 
                

            }else{
                w[rootb] += w[roota];
                p[roota] = p[rootb]; 
                
 
            }
                count--;
            }
            
        }
        
        public void merge(){
            
            for(int i=0;i<n;i++){
                find(i);
            }
        }
        
        public DS(int n){
            this.n = n;
            count = n;
            p = new int[n];
            w = new int[n];
            
            for(int i=0;i<n;i++){
                p[i] = i;
                w[i] = 1;
            }
        }
    }
    
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> mailMap = new HashMap<>();
        
        int n = accounts.size();
        
        DS ds = new DS(n);
        
        for(int i=0;i<n;i++){
            List<String> acc =  accounts.get(i);
            
            int m = acc.size();
            
            String name = acc.get(0);
            
            for(int j=1;j<m;j++){
                
                if(mailMap.containsKey(acc.get(j))){
                    ds.union(mailMap.get(acc.get(j)), i);
                    //break;
                }else{
                    mailMap.put(acc.get(j), i);
                }
            }
        }
        ds.merge();
        
        HashMap<Integer, TreeSet<String>> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int key = ds.p[i];
            
            TreeSet<String> ts = hm.getOrDefault(key, new TreeSet<>());
            
            List<String> acc = accounts.get(i);
            
            int m = acc.size();
            
            for(int j=1;j<m;j++){
                
                ts.add(acc.get(j));
            }
            
            hm.put(key, ts);
        }
        
        List<List<String>> res = new LinkedList<>();
        
        for(Integer key : hm.keySet()){
            
            TreeSet<String> ts = hm.get(key);
            
            LinkedList<String> list = new LinkedList<>(ts);
            
            String name = accounts.get(key).get(0);
            
            list.offerFirst(name);
            
            res.add(list);
        }
        
        return res;
    }
}