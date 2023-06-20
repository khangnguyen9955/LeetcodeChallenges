class Solution {
    public boolean canJump(int[] nums) {
        /*
        int cur = nums[0];
        for(int i = 1; i<nums.length;i++){
            if(cur < i) return false;
            // nums[i]+i => stand position i and can jump nums[i] steps
            // or prev max step (cur)
            cur = Math.max(cur, nums[i]+ i);
            if(cur >= nums.length) return true;
        }
        return true;
        */
        
        int res = nums[nums.length-1];
        for(int i =nums.length-1;i>=0;i--){
            if(nums[i] + i >= res){
                res = i;
            }
        }
        if(res == 0) return true;
        return false;
    }


}