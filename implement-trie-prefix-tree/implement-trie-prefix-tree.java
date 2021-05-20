class Trie {

   class Node{
        Node[] children = new Node[26];
        //int noOfWordsWithThisPrefix = 0;
        boolean doesWordEndHere = false;
        char c;
        public Node(char c){
            this.c = c;
        }
    }

    Node head = null;
    /** Initialize your data structure here. */
    public Trie() {
         head = new Node('*');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node currentNode = head;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(currentNode.children[index] == null){
                currentNode.children[index] = new Node(word.charAt(i));
            }
            currentNode = currentNode.children[index];
            //currentNode.noOfWordsWithThisPrefix++;
        }
        currentNode.doesWordEndHere = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node currentNode = head;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(currentNode.children[index] == null){
                return false;
            }
            currentNode = currentNode.children[index];
        }
        if(currentNode.doesWordEndHere){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node currentNode = head;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(currentNode.children[index] == null 
               //|| //currentNode.children[index].noOfWordsWithThisPrefix < 1
              ){
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */