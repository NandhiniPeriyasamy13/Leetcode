/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        List<Integer> candidates = new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(i != j){
                   if(knows(i,j)){
                       flag = false;
                       break;
                   } 
                }
            }
            if(flag){
                candidates.add(i);
            }
        }
        
        for(int val : candidates){
            boolean flag = true;
            for(int i=0;i<n;i++){
                if(!knows(i,val)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return val;
            }
        }
        return -1;
    }
}