class Solution {
    public int jump(int[] nums) {
        int left = 0, right = 0,  res= 0;
        // BFS
        // [2 ,3 , 1, 1, 4]
        // from 2 we traverse bfs to []3,1]
        // from [3,1] we can traverse to [1,4]
        
        while(right < nums.length-1){
            int farthestMove = 0;
            for(int i = left;i<=right;i++){
             farthestMove = Math.max(farthestMove, nums[i]+i);
            }
            res++;
            left = right+1;
            right = farthestMove;
        }
        return res;
    }
}