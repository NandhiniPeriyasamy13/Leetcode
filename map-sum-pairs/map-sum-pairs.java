class MapSum {
    
    class Node{
        char ch;
        Node[] children = new Node[26];
        HashSet<String> prefix = new HashSet<>();
        boolean doesWordEndHere = false;
        
        public Node(char ch){
            this.ch = ch;
        }
        
    }
    
    class Trie{
        Node root = null;
        public Trie(){
            root = new Node('*');
        }
        
        
        public void insert(String str){
            Node cur = root;
            
            int n = str.length();
            for(int i=0;i<n;i++){
                char ch = str.charAt(i);
                int index = ch - 'a';
                if(cur.children[index] == null){
                    cur.children[index] = new Node(ch);
                }
                
                cur = cur.children[index];
                cur.prefix.add(str);
            }
            cur.doesWordEndHere = true;
        }
        
        public HashSet<String> getStringList(String prefix){
            Node cur = root;
            int n = prefix.length();
            
            for(int i=0;i<n;i++){
                int index = prefix.charAt(i) - 'a';
                if(cur.children[index] == null){
                    return null;
                }
                cur = cur.children[index];
            }
            
            return cur.prefix;
        }
    }
    
    HashMap<String, Integer> map;
    Trie trie;
    
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
        trie.insert(key);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        HashSet<String> str = trie.getStringList(prefix);
        if(str != null && !str.isEmpty()){
            for(String s: str){
                sum += map.getOrDefault(s,0);
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */