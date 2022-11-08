class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length < 3){
           return Collections.emptyList();
        } // base case, length <3 => return empty list;
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length-2;i++){ 
            int j = i+1;
            int k = nums.length-1;
            // create 2 pointers to traverse, the next of left pointer and right pointer 
            while(j<k){
                int totalSum = nums[i] + nums[j] +nums[k]; 
                if(totalSum == 0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    // found triplet, now move 2 pointers to find more
                }
                // cause we sorted array
                // if totalSum < 0
                // we need to shift the j (left pointer) to the right
                else if(totalSum < 0){
                    j++;
                }
                // else we shift the right pointer to left
                else if (totalSum > 0){
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}