class Node{
    char ch;
    Node[] children = new Node[26];
    List<String> sugg = new ArrayList<>();
    public Node(char ch){
        this.ch = ch;
    }
}

class Trie{
    
    Node head = null;
    
    public Trie(){
        head = new Node('*');
    }
    
    public void insert(String word){
        Node cur = head;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a'] == null)
                cur.children[ch-'a'] = new Node(ch);
            cur = cur.children[ch-'a'];
            if(cur.sugg.size()  < 3)
                cur.sugg.add(word);
        }
    }
    
    public List<List<String>> search(String word){
        List<List<String>> ans = new ArrayList<>();
        Node cur = head;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur != null && cur.children[ch-'a'] != null){
                ans.add(cur.children[ch-'a'].sugg);
                cur = cur.children[ch-'a'];
            }else{
                ans.add(new ArrayList<>());
                cur = null;
            }
            
            
        }
        return ans;
    }
    
    
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        Arrays.sort(products);
        for(int i=0;i<products.length;i++){
            trie.insert(products[i]);
        }
        return trie.search(searchWord);
    }
}