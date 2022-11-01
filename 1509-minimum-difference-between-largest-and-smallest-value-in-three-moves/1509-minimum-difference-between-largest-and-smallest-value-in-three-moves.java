class Solution {
    public int minDifference(int[] nums) {

if (nums.length <= 4){
   return 0;
}
        int diff =Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int l = 0 ;l<= 3;l++){
            diff = Math.min(nums[nums.length-4+l]-nums[l],diff);
        }
            return diff;
         
    }
}
