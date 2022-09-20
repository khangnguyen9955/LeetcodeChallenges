class Solution {
    public int orangesRotting(int[][] mat) {
        int m =mat.length, n =mat[0].length;
        
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0 ; i< m;i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 2){
                   queue.offer(new int[]{i,j}); 
                    // put the position of rotten orange to queue
                }
                else if(mat[i][j]==1){
                    countFresh++;
                }
            }
        }
        
        if(countFresh == 0) return 0;
        int countMin=0;
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}}; 
        // create the index direction
        while(!queue.isEmpty()){
            countMin++;
            int size = queue.size();
            for(int i = 0 ; i < size;i++){
                int [] pos = queue.poll(); //get the first pos and remove
                for(int [] dir : dirs){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    
                    // if invalid pos, or that cell is empty, is rotten, continue;
                   if(x < 0 || y < 0 || x >= m || y >= n || mat[x][y] == 2 || mat[x][y] == 0) continue;
                    
                    // if this cell is fresh, now it will be rotten
                   mat[x][y] = 2;
                    countFresh--;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        
        return countFresh == 0 ? countMin-1 : -1; // count -1 because we increased the first rotten
    }
}