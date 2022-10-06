class Solution {
    public List<List<String>> solveNQueens(int n) {
       int [][] board = new int[n][n];
        List<List<String>> result = new LinkedList<>();
        backtracking(result,0,n, new LinkedList<String>(), new int[2*n] , new int[2*n], new int[2*n]);
        return result;
    }
    public void backtracking(List<List<String>> result, int col, int n, List<String> path, int[] ld, int [] rd, int [] cl ){
       if(col >= n){
           // full=> return.
           result.add(new LinkedList<>(path));
           return;
       }
        for(int row = 0 ; row < n;row++){
            // row-col+n-1 means left diagonal, write it down to the paper with some position examples will understand
            // row+col means right diagonal
            // cl[row] this row cannot be same
            // ensure that not same col because we call col+1
            if(ld[row-col+n-1] != 1 && rd[row+col] != 1 && cl[row] != 1){
               ld[row-col+n-1] =
                rd[row+col]=
                cl[row]=1;
                // now this pos is possible to placed the Queen, append it and recursive
                StringBuilder str = new StringBuilder();
                for(int i =0 ;i<n;i++) str.append('.');
                str.setCharAt(row,'Q');
                path.add(str.toString());
                backtracking(result,col+1,n,path,ld,rd,cl);
                // now the path above is not possible, backtrack and remove it out of the list paths
                ld[row-col+n-1]=
                rd[row+col]=
                cl[row]=0;
                path.remove(path.size()-1);
            }
        }
    }
}