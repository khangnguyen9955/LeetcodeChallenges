class Solution {
    public int minCostClimbingStairs(int[] cost) {
       // We can either choose index 0 or 1 
       // step i will cost cost[i] 
       // each step we pay we can climb one or two steps
       // calculate minimum cost to reach the top of the floor
       int [] dp = new int [cost.length];
       dp[0] = cost[0];
       dp[1] = cost[1];
       for(int i =2;i<cost.length;i++){
           dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
       }
       return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
}