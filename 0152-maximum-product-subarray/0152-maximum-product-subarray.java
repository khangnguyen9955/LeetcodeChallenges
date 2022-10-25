class Solution {
    public int maxProduct(int[] nums) {
        int size = nums.length;
    int maxpre =nums[0];
        int minpre = nums[0];
        int max = nums[0];
        int maxhere =0 ;
            int minhere=0;
        if(size==0){
            return 0;
        }
        for(int i =1 ; i< size;i++){
            maxhere = Math.max(Math.max(maxpre*nums[i],minpre*nums[i]),nums[i]);
            minhere = Math.min(Math.min(maxpre*nums[i],minpre*nums[i]),nums[i]);
            max = Math.max(max,maxhere);
            maxpre = maxhere;
            minpre = minhere;    
        }
    
    
    return max;
    }
}