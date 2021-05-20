class MovingAverage {

    Queue<Integer> q;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        q.add(val);
        sum += val;
        if(q.size() > size){
            sum -= q.poll();
        }
        
        return (double)sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */