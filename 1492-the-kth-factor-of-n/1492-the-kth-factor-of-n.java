class Solution {
    public int kthFactor(int n, int k) {
       
        
// first loop is a straightforward when want to find factors
// for example: n = 12
        // sqrt(n)=3,4...
        // loop from 1 to 3
       for(int i = 1; i < Math.sqrt(n); i++){
           if(n%i==0 && --k ==0){
               return i;
           }
       }
        // second loop is important
        // we still use sqrt(n)
        // but now we will take the factor (n/i) to check whether if we divide factor will get
        // another factor or not? => n % (n/i) == 0?
        
        for (int i =(int) Math.sqrt(n); i>=1;i--){
            if(n%(n/i) == 0 && --k==0){
                return n/i;
            }
        }
        return -1;
    }
}