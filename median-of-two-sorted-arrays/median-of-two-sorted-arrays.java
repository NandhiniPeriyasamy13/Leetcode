class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        
        int m = nums1.length;
        int n = nums2.length;
        
        int i=0;
        int j=0;
        int k = 0;
        
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i];
                i++;
            }else{
                nums[k++] = nums2[j];
                j++;
            }
        }
        
        while(i<m){
            nums[k++] = nums1[i];
            i++;
        }
        
        while(j<n){
            nums[k++] = nums2[j];
            j++;
        }
        
        double ans = 0;
       int mid = (int)Math.floor((m+n)/2);
        if((m+n) % 2 == 0){ 
            return (nums[mid]+nums[mid-1])/2.0;
        }else{
            
            return nums[mid];
        }
    }
}