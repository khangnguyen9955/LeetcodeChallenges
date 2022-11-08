class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] nums = new int [nums1.length + nums2.length];
        double res = 0;
        // if the length is odd => return the middle
        // else the length is even => return the two middle
        int i=0;
        int j= 0;
        int k=0;
        while(j < nums1.length && k < nums2.length){
            if(nums1[j] > nums2[k]){
                nums[i]=nums2[k];
                i++;
                k++;
            }
            else {
                nums[i]=nums1[j];
                i++;
                j++;
            }
        }
        while(j < nums1.length){
            nums[i] = nums1[j];
            i++;
            j++;
        }
        while(k < nums2.length){
            nums[i] = nums2[k];
            i++;
            k++;
        }
        if(nums.length%2==0){
            res = (nums[nums.length/2] + nums[nums.length/2 -1])/2.0;
        }
        else{
            res = nums[nums.length/2];
        }
        return res;
    }
}