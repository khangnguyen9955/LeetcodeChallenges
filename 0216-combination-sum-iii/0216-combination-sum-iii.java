class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         // set = {1,2,3,4,5,6,7,8,9}
        // take it as an array 
        // we got k numbers can use in this set;
        // each number in the list can be used only once
        // we can create a boolean[] flag to check the above condition
        // with the process check to choose next num
        // i think we can implement the binarysearch to use (?) instead of linear search
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),n,1,k);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> list, int remain,int start,int k){
        if (remain ==0 && k==list.size()){
            res.add(new ArrayList<>(list));
            return;
         }
        else if(remain > 0 && list.size() < k) {
            for (int i = start; i<=9;i++){
            list.add(i);
            backtrack(res,list,remain-i,i+1,k);
            list.remove(list.size()-1);
        }
        }
    }
}