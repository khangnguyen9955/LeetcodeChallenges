class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // problem: return the sum of triplet that closest to the target 
        if(nums.length == 3){
            return nums[0] + nums[1] + nums[2];
        }
        int result = Integer.MAX_VALUE;
        int closest = 0;
        Arrays.sort(nums);
        // -4, -1, 1, 2
        for(int i = 0; i < nums.length-2; i++ ){
            int j = i+1;
            int k = nums.length -1;
            while(j < k ){
                int threeSum = nums[i] + nums[j] +nums[k]; 
                if(threeSum == target){
             // if threesum == target means that distance = 0; return three sum
                    return threeSum;    
                }  
                else if(threeSum >target){
                    // if the threesum > target
                    // now we want threeSum will be smaller
                    // to get closer to the target
                    k--;
                }
                else if(threeSum < target){
                    //same with above
                    // threeSum < target
                    // we want it will be larger
                    // to closer to the target
                    j++;                   
                }
                if(Math.abs(target-threeSum) < result){
                    // if abs(target - threeSum) < result 
                    // means that we got a closer sum
                    // update it!
                     result = Math.abs(target - threeSum );                       
                     closest = threeSum;
                    } 

            }
        }
        return closest;
        
    }
}