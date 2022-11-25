class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // given an array distinc integers candidates
        // given a target interget 
        // return a list of all unique combinations of candidates
        // where the chosen numbers sum to target
        // can choose the same number for an unlimited of times (!!!)
        // two combinations are unique if the frequency of at least one of the chosen numbers is different (!!!)
        // constraint: the unique combinations < 150
        // solution: calculate the remain value after adding each number
        // if the remain < 0 => means those numbers > target
        // if the remain == 0 => found first unique combination, add into res list
        // else remain > 0 => continue backtrack
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,new ArrayList<>(),res, target, 0);
        return res;
        }
    /*
    public void backtrack(int[]candidates,  List<Integer> list , List<List<Integer>> res, int remain, int start){
        if (remain < 0 ) return;
        else if(remain == 0 ) res.add(new ArrayList<>(list));
        else{
            for (int i = start; i< candidates.length;i++){
                list.add(candidates[i]);
                backtrack(candidates,list,res,remain-candidates[i],i); 
                // still back track with "i" due to we can choose the same number for an unlimited of times
                list.remove(list.size()-1);
            }
        }
    }
    */
    // IMPROVEEEEEE solution
    public void backtrack(int[]candidates,  List<Integer> list , List<List<Integer>> res, int remain, int start){
        if(start == candidates.length){ // reach the end of the candidates[]
            if(remain ==0){  //now check if we found solution yet or not 
                res.add(new ArrayList<>(list));
            }
            return;
        }
        // not found solution 
        // so this case is the remain still >= the candidate[i]
        // means we can add this candidate into list
        if (candidates[start] <= remain){
                list.add(candidates[start]);
                backtrack(candidates,list,res,remain-candidates[start],start); 
                // still back track with "i" due to we can choose the same number for an unlimited of times
                list.remove(list.size()-1);
        }
        // this case here means the remain > target
        // move for the new backtrack
        backtrack(candidates,list,res,remain,start+1);
    }
     
}