class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int [][] dp = new int [s1.length()+1][s2.length()+1];
        dp[0][0] = 0;
        
// plus all the s1 in first row
        for(int i = 1; i <= s1.length();i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        // plust all s2 in first col
        for(int i = 1 ;i <= s2.length();i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        
        for(int i = 1; i <= s1.length();i++){
            for(int j = 1; j<= s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                    // if same , we will skip add these words
                }
                else{
                    // if not same, then get the min of prev selection plus with current 
                    dp[i][j]= Math.min((dp[i-1][j] + s1.charAt(i-1) ),(dp[i][j-1] + s2.charAt(j-1)));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}