class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] result = new int [r][c];
        
        if(r*c != n*m) return mat;
        
        for (int i =0;i<c*r;i++){
            result[i/c][i%c] = mat[i/n][i%n];
        }        
        return result;
    }
}