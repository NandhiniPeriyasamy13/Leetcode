class Solution {
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    List<Integer> res = new ArrayList<>(); 
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for(int i=0;i<ppid.size();i++){
            List<Integer> children = hm.getOrDefault(ppid.get(i), new ArrayList<>());
            children.add(pid.get(i));
            hm.put(ppid.get(i), children);
        }
        addProcess(kill);
        return res;
        
    }
    
    private void addProcess(Integer kill){
        res.add(kill);
        if(hm.containsKey(kill)){
            List<Integer> list = hm.get(kill);
            for(Integer val : list){
                addProcess(val);
            }
        }
    }
}