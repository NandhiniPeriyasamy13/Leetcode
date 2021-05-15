class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int maxCapacity = 5000;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            maxCapacity -= arr[i];
            if(maxCapacity <=0){
                break;
            }
            res++;
        }
        return res;
    }
}