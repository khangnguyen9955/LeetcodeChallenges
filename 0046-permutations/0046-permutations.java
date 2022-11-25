class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(nums, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtracking(int [] nums, List<Integer> list , List<List<Integer>> result){
        if (list.size()== nums.length){ // enough nums in the list
            result.add(new ArrayList<>(list));
        }else{
        for(int i = 0 ; i < nums.length; i++){
            if(list.contains(nums[i])) continue; // skip contained num
            list.add(nums[i]);
            backtracking(nums,list,result);
            list.remove(list.size()-1); // remove the last number just added into list
        }
        }
    }
}