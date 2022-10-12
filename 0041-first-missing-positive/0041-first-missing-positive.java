class Solution {
    public int firstMissingPositive(int[] nums) {
        // loop to find negative elements
        for (int i =0 ; i<nums.length;i++){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }
        
        // here, we transform any number that appear in input data to negative number to mark it does exist in our array
        for(int i = 0; i<nums.length;i++){
            int value = Math.abs(nums[i]);
            
            // in this case we just need to consider 1 -> value because the constraint tell that 1<= nusm.length
         if( 1 <= value && value <= nums.length ){ 
            if(nums[value-1] > 0){
                nums[value-1] *= -1;
            }
            else if (nums[value-1] == 0){
                nums[value-1] = -1 * (nums.length+1);
            }
        }
        }
        
        // find which is the first number is not negative and return it; 
        // else we return the length+1 of the input;
        for(int i = 1 ; i< nums.length+1;i++){
            if(nums[i-1] >= 0){
                return i;
            }
        }
        
        return nums.length+1;
    }
}