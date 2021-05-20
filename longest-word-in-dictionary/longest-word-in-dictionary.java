class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        
        int maxLen = 0;
        String res = "";
        for(int i=0;i<words.length;i++){
            int wordChainLen = trie.getWordChainLength(words[i]);
            if(maxLen < wordChainLen){
                maxLen = wordChainLen;
                res = words[i];
            }else if (maxLen == wordChainLen && res.compareTo(words[i]) > 0){
                res = words[i];
            }
        }
        return res;
    }
    
    class Node{
        Node[] children = new Node[26];
        boolean doesWordEndHere = false;
        char c;
        public Node(char c){
            this.c = c;
        }
    }
    
    
    class Trie{
        Node head = null;
        public Trie(){
            head = new Node('*');
        }
        
        public void insert(String word){
            Node currentNode = head;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i) - 'a';
                if(currentNode.children[index] == null){
                    currentNode.children[index] = new Node(word.charAt(i));
                }
                currentNode = currentNode.children[index];
            }
            currentNode.doesWordEndHere = true;
        }
        
        public int getWordChainLength(String word){
            Node currentNode = head;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(!currentNode.children[index].doesWordEndHere){
                    return 0;
                }
                currentNode = currentNode.children[index];
            }
            return word.length();
        }
    }
}