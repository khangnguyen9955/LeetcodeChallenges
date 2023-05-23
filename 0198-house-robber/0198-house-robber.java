class Solution {
    public int rob(int[] nums) {
        // cannot rob 2 adjacent houses 
        // 5 2 3 10  => 15
        // prev1 = 0
        // prev2 = 0

        // tmp =0
        // prev1 = 5
        // prev2 = 0

        // tmp = 5
        // prev1 = 5
        // prev2 = 5

        // temp = 5
        // prev1 = 5+3, 5 => 8
        // prev2 = 5

        // temp = 8
        // prev1 = 8, 5+10 => 15
        // prev2 = 8

        // store the previous selection and compare with current version 
        int prev1=0,prev2=0;
        int tmp =0;
        for (int i=0; i < nums.length;i++){
           tmp = prev1;
           prev1 = Math.max(prev2+nums[i], prev1);
           prev2 = tmp;
        }
        return prev1;

    }
}