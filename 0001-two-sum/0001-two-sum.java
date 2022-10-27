class Solution {
    public int[] twoSum(int[] nums, int target) {
        
          HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        int [] results = new int [2];

        int temp = 0;
        for(int i = 0; i<nums.length;i++){
            temp = target-nums[i];
            if(map.containsKey(temp)){
                results[0] = i;
                results[1] = map.get(target-nums[i]);
               return results;
            }
            map.put(nums[i],i);
        }
            return results;

    }
}