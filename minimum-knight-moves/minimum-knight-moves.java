class Solution {
    Queue<Pair<Integer,Integer>> q = new LinkedList<>();
    boolean[][] visited = new boolean[605][605];
        
    public int minKnightMoves(int x, int y) {
        
        q.add(new Pair(0,0));
        int move = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> pair= q.poll();
                int x_val = pair.getKey();
                int y_val = pair.getValue();
                if(Math.abs(x_val+y_val) > 300){
                    continue;
                }
                if(x_val == x && y_val == y){
                    flag = true;
                    break;
                }
                
                addToQueue(new Pair(x_val+1,y_val+2));
                addToQueue(new Pair(x_val+1,y_val-2));
                addToQueue(new Pair(x_val-1,y_val+2));
                addToQueue(new Pair(x_val-1,y_val-2));
                addToQueue(new Pair(x_val+2,y_val+1));
                addToQueue(new Pair(x_val+2,y_val-1));
                addToQueue(new Pair(x_val-2,y_val+1));
                addToQueue(new Pair(x_val-2,y_val-1));
            }
            if(flag)
                break;
            move++;
        }

        return move;
    }
    
    private void addToQueue(Pair<Integer,Integer> pair){
        if(!visited[pair.getKey()+302][pair.getValue()+302]){
            q.add(pair);
            visited[pair.getKey()+302][pair.getValue()+302] = true;
        }
    }
}