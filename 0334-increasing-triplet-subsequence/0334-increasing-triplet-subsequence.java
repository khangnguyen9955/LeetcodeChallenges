class Solution {
    public boolean increasingTriplet(int[] nums) {
        int mid = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length; i++) {
            if ( mid < nums[i]){ // nums[i] > mid => nums[i] > left
                return true;
            }
            else if (nums[i] > left && nums[i] < mid ){
                mid = nums[i];
            }
            else if( nums[i] < left){
                left = nums[i];
            }
        }
        return false;

    }
}