class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums); 
        backtracking(nums, new ArrayList<Integer>(), result, new boolean [nums.length]);
        return result;
    }
    public void backtracking(int [] nums, List<Integer> list , List<List<Integer>> result, boolean []flag ){
        if (list.size()== nums.length){ // enough nums in the list
            result.add(new ArrayList<>(list));
        }else{
        for(int i = 0 ; i < nums.length; i++){
            if(flag[i] || i>0 && nums[i] == nums[i-1] && !flag[i-1] ) continue;
            // explanation: when we got 2 same nums
            // we need to check if the previous same nums is still in our process adding
            // or not, if yes then we still add new num
            // but if not, means that we are in the process of removing last num
            // so if the next num nums[i] == nums[i-1] // means new num equals old num
            // but flag[i-1] == false  // means old num is removed
            // we will exit, avoiding infinity loop// duplicated cases
            flag[i] = true; // flag contained
            list.add(nums[i]);
            backtracking(nums,list,result,flag);
            flag[i] = false; // remove flag
            list.remove(list.size()-1); // remove the last number just added into list
        }
        }
    }
}