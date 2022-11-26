class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // same with combinationSum but now we have to check duplicated nums
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), target, 0, candidates);
        return res;
    }
    public void backtrack ( List<List<Integer>> res, List<Integer> list, int remain , int start, int [] nums){
        if(remain ==0){
            res.add(new ArrayList<>(list));
            return;
        }
        else
        {
            for( int i = start ;i < nums.length; i++){
            if(i >start  && nums[i] == nums[i-1]) // avoiding duplicated numbers
            {continue;}
           if(nums[i] > remain)   break; // base case
            list.add(nums[i]);
            backtrack(res,list,remain-nums[i],i+1, nums);
            list.remove(list.size()-1);
            }
        }
    }
}