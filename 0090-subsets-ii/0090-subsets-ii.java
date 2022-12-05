class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(); 
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(), nums,0);
        return list;        
    }
    
    public void backtrack(List<List<Integer>> list ,  List<Integer> tempList, int[] nums,int start){
        list.add(new ArrayList<>(tempList));
            for(int i =start ; i< nums.length; i++){
            if (i == start || nums[i] != nums[i - 1]){ // tranh truong hop duplicate , neu i khac start, co nghia la i da chay den het array roi, remove va backtrack len di
                tempList.add(nums[i]);
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);}
        }
    }
}