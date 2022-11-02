class Solution {
    public int searchInsert(int[] nums, int target) {
       int low = 0;
        int hi = nums.length-1;
        while(low<=hi){
        int mid = (low+hi)/2;
            if(nums[mid] == target ) return mid;
            else if (nums[mid] > target) {
                hi = mid-1;
            }
            else{
                low= mid+1;
            }    
        }
        return low;
    }
}