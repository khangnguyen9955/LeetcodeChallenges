class Solution {
    public int removeDuplicates(int[] nums) {
        // 1 2 3 4 5
        // remove duplicates 
        // each unique num can appear at most twice
        // keep order same
        int len = nums.length;
        
        int k = 2 ; // at most twice 

        if(len < 2 ) return len;

        // start pointer
        int countPointer = 1;

        // count occurence time of num
        int occTimes = 1;

        for(int i = 1 ; i< len;i++){
            if(nums[i] == nums[i-1]){
                if(occTimes< k ){ 
                    // this num still valid
                    nums[countPointer]  = nums[i];
                    countPointer++; // move count pointer
                }
                occTimes++;
            } // if diff nums then count back to 1 and just move result pointer 
            else{
                occTimes = 1; // back counter to 1 to count new num
                nums[countPointer] = nums[i];
                countPointer++;
            }
        }
        return countPointer;
    }
}