class DLL{
    int val;
    DLL prev;
    DLL next;
    
    public DLL(){}
    
    public DLL(int val){
        this.val = val;
    }
}



class MaxStack {

    DLL head = new DLL(-1);
    DLL tail = new DLL(-1);
    TreeMap<Integer, List<DLL>> tmap = new TreeMap<>((a,b) -> b - a);
    
    
    public MaxStack() {
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        DLL node = new DLL(x);
        DLL next = head.next;
        head.next = node;
        next.prev = node;
        node.prev = head;
        node.next = next;
        
        List<DLL> nodeList = tmap.getOrDefault(x, new ArrayList<DLL>());
        nodeList.add(node);
        if(!nodeList.isEmpty())
            tmap.put(x, nodeList);
    }
    
    public int pop() {
        DLL node = head.next;
        int val = node.val;
        DLL next = head.next.next;
        head.next = next;
        next.prev = head;
        node.prev = null;
        node.next = null;
        
        List<DLL> nodeList = tmap.get(val);
        nodeList.remove(nodeList.size()-1);
        if(!nodeList.isEmpty())
            tmap.put(val, nodeList);
        else
            tmap.remove(val);
        
        return val;
    }
    
    public int top() {
          
       return head.next.val; 
    }
    
    public int peekMax() {
        return tmap.firstKey();
    }
    
    public int popMax() {
        List<DLL> nodeList = tmap.pollFirstEntry().getValue();
        DLL node = nodeList.remove(nodeList.size()-1);
        if(!nodeList.isEmpty())
            tmap.put(node.val, nodeList);
        
        
        DLL pnode = node.prev;
        DLL nnode = node.next;
        pnode.next = nnode;
        nnode.prev = pnode;
        node.next = null;
        node.prev = null;
        return node.val;
    }
    
    private void print(){
        DLL cur = head;
        
        while(cur != null){
          System.out.print(cur.val);
            cur = cur.next;
        }
        
        System.out.println("");
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */