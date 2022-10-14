class Solution {
    public int maxSubArray(int[] nums) {
  int max = Integer.MIN_VALUE;
            int maxEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEnd += nums[i];

            max = maxEnd > max ? maxEnd : max;
        if(maxEnd < 0 ){
            maxEnd = 0;
        }
        }
        return max; 
    }
}