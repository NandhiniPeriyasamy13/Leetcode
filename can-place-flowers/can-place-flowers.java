class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1){
            if(flowerbed[0] != 1){
                flowerbed[0] = 1;
                n--;
            }
        }else{
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] != 1){
                if(i == 0){
                    if(flowerbed[i+1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    } 
                }else if(i == flowerbed.length-1){
                    if(flowerbed[i-1]  == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }else if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            
                if(n == 0){
                    break;
                }
            }
        }
        }
        return n <= 0 ? true : false;
    }
}