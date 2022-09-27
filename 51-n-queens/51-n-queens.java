class Solution {
    public List<List<String>> solveNQueens(int n) {
       int [][] board = new int[n][n];
        List<List<String>> result = new LinkedList<>();
        backtracking(result,0,n, new LinkedList<String>(), new int[2*n] , new int[2*n], new int[2*n]);
        return result;
    }
    
    
    
    public void backtracking(List<List<String>> result, int col, int n, List<String> path, int[] ld, int [] rd, int [] cl ){
       if(col >= n){
           result.add(new LinkedList<>(path));
           return;
       }
       
        for(int row = 0 ; row < n;row++){
            if(ld[row-col+n-1] != 1 && rd[row+col] != 1 && cl[row] != 1){
               ld[row-col+n-1] =1;
                rd[row+col]=1;
                cl[row]=1;
                StringBuilder str = new StringBuilder();
                for(int i =0 ;i<n;i++) str.append('.');
                str.setCharAt(row,'Q');
                path.add(str.toString());
                backtracking(result,col+1,n,path,ld,rd,cl);
                ld[row-col+n-1]=0;
                rd[row+col]=0;
                cl[row]=0;
                path.remove(path.size()-1);
                
            }
            
            
        }
    }
}