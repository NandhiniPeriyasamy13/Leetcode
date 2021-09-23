class FNode{
    char ch;
    int freq;
    
    public FNode(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<FNode> pq = new PriorityQueue<>((f1,f2) -> f2.freq - f1.freq);
        pq.add(new FNode('a', a));
        pq.add(new FNode('b', b));
        pq.add(new FNode('c', c));
        
        while(true){
            FNode f = pq.poll();
            if(f.freq == 0)
                break;
            
            
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == f.ch){
                FNode s = pq.poll();
                if(s.freq > 0){
                    pq.add(f);
                    int fr = getCount(f.freq, s.freq);
                    append(sb, s.ch, fr);
                    s.freq -= fr;
                    s.freq = s.freq > 0 ? s.freq : 0;
                }
                pq.add(s);
            }else{
                append(sb, f.ch, f.freq);
                f.freq = Math.max(0, f.freq - 2);
                pq.add(f);
            }
        }
        
        return sb.toString();
    }
    
    private void append(StringBuilder sb, char ch, int count){
        int i = 0 ;
        
        while(count > 0 && i++ < 2){
            sb.append(ch+"");
            count--;
        }
    
        
    }
    
    private int getCount(int a, int b){
        double a1 = Math.ceil(a/2.0);
        double a2 = Math.floor(b/2.0);
        
        int ans = a1 > a2 ? 1 : 2;
//         System.out.print(a1);
//         System.out.print(a2);
//         System.out.println(ans);
        
        return ans;
    }
}