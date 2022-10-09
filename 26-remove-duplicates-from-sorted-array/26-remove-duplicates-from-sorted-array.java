class Solution {
     public static int removeDuplicates(int[] nums) {
            int n = nums.length;
            int j = 0;

        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[j]){
                    nums[++j] = nums[i];
            }
        }
return j+1;
    }
}