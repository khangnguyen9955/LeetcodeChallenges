class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         List<List<Integer>> list = new LinkedList<>();
        if(heights == null ||heights.length == 0 ||heights[0].length == 0){
            return list;
        }
        int rows =heights.length, cols =heights[0].length;
        boolean[][]foundPacific = new boolean[rows][cols];
        boolean[][]foundAtlantic = new boolean[rows][cols];
        int preValue = Integer.MIN_VALUE;
        for(int i=0; i< rows; i++){
            // go vertical
            dfs(heights, foundPacific, preValue, i, 0); // row i, col 0 
            dfs(heights, foundAtlantic, preValue, i, cols-1); // row i, col cols-1 
        }
        for(int i=0; i<cols; i++){
            // go horizontal
            dfs(heights, foundPacific, preValue, 0, i); // row 0 , col i
            dfs(heights, foundAtlantic, preValue, rows-1, i); // row rows-1, col i
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (foundPacific[i][j] && foundAtlantic[i][j]) 
                {
                  List<Integer>res= new LinkedList<>();
                    res.add(i);
                    res.add(j);
                    list.add(res);
                }
             }   
        }
                                   
        return list;
    }
    int[][]dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(int[][]mat, boolean[][]visited, int preValue, int row, int col){
        int rows = mat.length, cols = mat[0].length;
        if(row<0 || row>=rows|| col<0 || col>=cols || visited[row][col] || mat[row][col] <preValue)
            return;
        visited[row][col] = true;
        for(int[]dir:dirs){
            dfs(mat, visited, mat[row][col], row+dir[0], col+dir[1]); // 4 mutations
        }
    }
    
}
