class Solution {
        int [][]dirs = new int [][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // pacific ocean is when we at the r[0] and c[0]
        // atlantic ocean is when we at the r[height.length] c[height[0].length];
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> list = new LinkedList<>();
        if(heights == null || rows == 0 || cols == 0){
            return list;
        }
        boolean [][] foundPacific = new boolean[rows][cols]; //check when found pacific
        boolean [][] foundAtlantic = new boolean [rows][cols];      
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        // add all the cells as vertical border to the queue
        for(int i = 0 ; i<rows;i++){
            pacificQueue.offer(new int []{i,0});
            atlanticQueue.offer(new int [] {i,cols-1});
            foundPacific[i][0]=true;
            foundAtlantic[i][cols-1]=true;
        }
        //add all the cells as horizontal border to the queue
        for(int j = 0 ;j <cols;j++){
            pacificQueue.offer(new int []{0,j});
            atlanticQueue.offer(new int []{rows-1,j});
            foundPacific[0][j]=true;
            foundAtlantic[rows-1][j]=true;
        }
        bfs(heights,pacificQueue,foundPacific);
        bfs(heights,atlanticQueue,foundAtlantic);       
        
        for(int i = 0 ; i < rows;i++){
            for(int j =0 ; j < cols; j++){
               List<Integer> result = new LinkedList<>();
               if(foundPacific[i][j] && foundAtlantic[i][j] ) {
                   result.add(i);
                   result.add(j);
                   list.add(result);
               }
            }
        }
        return list;
    }
    public void bfs (int [][]mat, Queue<int []> queue,boolean[][]found){
        int rows = mat.length;
        int cols = mat[0].length;
        while(!queue.isEmpty()){
            int [] current = queue.poll();
            for(int []dir:dirs){
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if( x < 0 || y>=cols || y < 0 || x >= rows  || found[x][y] || mat[x][y] < mat[current[0]][current[1]] ){ continue;}
                  found[x][y] = true;
                  queue.offer(new int[] {x,y});
            }
        }
        
    }
    
}
