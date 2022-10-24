class Solution {
    public int majorityElement(int[] nums) {
        int counter = 1;
        int major = nums[0];
        for(int i=1;i<nums.length;i++){
            if(counter == 0){
                counter++;
                major = nums[i];
            }
            else if(nums[i] == major){
                counter++;
            }
            else{
            counter--;
            }
    
        }
        // https://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step07
      return major;  
        
        
        
    }
}