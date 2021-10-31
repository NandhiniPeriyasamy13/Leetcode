class Solution {
    public int totalFruit(int[] fruits) {
        int windowCount = 0;
        int windowStart = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int windowEnd = 0;windowEnd < fruits.length;windowEnd++){
            hm.put(fruits[windowEnd], hm.getOrDefault(fruits[windowEnd],0)+1);
            while(hm.size() > 2){
                Integer fruit = fruits[windowStart];
                hm.put(fruit, hm.get(fruit)-1);
                if(hm.get(fruit) == 0)
                    hm.remove(fruit);
                windowStart++;
            }
            
            windowCount = Math.max(windowCount, windowEnd-windowStart+1);
        }
        return windowCount;
    }
}