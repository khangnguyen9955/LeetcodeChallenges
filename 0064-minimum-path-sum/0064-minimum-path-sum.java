class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i< m ;i++ ){
            grid[i][0]  += grid[i-1][0];
        }
        // 1 3 1
        // 1 5 1
        // 4 2 1
        // =>
        // 1 3 1 
        // 2 5 1
        // 6 2 1
        
        for(int i =1 ; i< n;i++){
            grid[0][i] += grid[0][i-1];
        }
        // 1 3 1
        // 2 5 1
        // 6 2 1
        // =>
        // 1 4 5
        // 2 5 1
        // 6 2 1
        

        int [][] dp = new int [m][n];
        for (int i = 1 ; i < m;i++){
            for (int j = 1 ; j < n ;j++){
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}