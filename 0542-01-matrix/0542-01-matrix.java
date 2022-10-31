class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int max =  mat[0].length + mat.length;
        for(int i = 0 ; i < mat.length;i++){
            for(int j = 0 ; j < mat[0].length;j++){
                if(mat[i][j] == 0 ) continue;
                  int a = max, c = max;
                  if(i>0 ) a = mat[i-1][j];
                  if(j>0) c=mat[i][j-1];
                  mat[i][j] = Math.min(a,c) + 1;
            }
        }
        for(int i = mat.length-1 ; i>=0;i--){
            for(int j = mat[0].length-1 ; j >=0 ;j--){
             if(mat[i][j] == 0) continue;
                    int b=max,d=max;
                      if(i<mat.length-1) b=mat[i+1][j]; 
                      if(j<mat[0].length-1) d = mat[i][j+1]; 
                      mat[i][j] = Math.min(Math.min(b,d) + 1,mat[i][j]);
                 
             
            }
        }
        
        return mat;
    }
    
    
    /*public void helper (int [][] mat, int  i, int j){
        int a = Integer.MAX_VALUE,b = Integer.MAX_VALUE,c = Integer.MAX_VALUE,d = Integer.MAX_VALUE;
        System.out.println("current: " + mat[i][j] + " " +  i + " " + j );
        if(i>0 ){
             a =mat[i-1][j];
        }
        if(i<mat.length-1)
        {b=mat[i+1][j]; }
        if(j>0)
        {c=mat[i][j-1] ;}
        if(j<mat[i].length-1)
        { d =mat[i][j+1]; }
         System.out.println("top: " + a);
         System.out.println("bottom: " +  b);
         System.out.println("left: " + c);
         System.out.println("right: " + d);
        mat[i][j] += Math.min(Math.min(a,b), Math.min(c,d));
          System.out.println("result: " + mat[i][j] );
      
      
    }*/
}