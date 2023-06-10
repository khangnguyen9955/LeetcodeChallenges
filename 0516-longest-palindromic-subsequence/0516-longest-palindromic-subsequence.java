class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int [][] dp = new int[s.length()][s.length()];
        for (int i = 0 ;i < s.length();i++){
            dp[i][i] = 1;
            // initialize default value for every character
        }
            
        for (int winSize = 2; winSize <= len; winSize++){
            // first winSize is 2, then expand winSize
            // a g b d b a
            // 1 2
            // and continously checking a subsequence string with windowSize
            // a g b d b a
            //   1 2
            // ...
            // a g b d b a 
            // 1 2 3
            // a g b d b a
            //   1 2 3
            
            for(int startIndex = 0; startIndex <= len-winSize; startIndex++ ){
                // 
                int endIndex = startIndex+winSize-1;
                if (s.charAt(startIndex) ==s.charAt(endIndex)){
                    // if same 
                    // get longest string between startIndex and endIndex
                    dp[startIndex][endIndex] = 2 + dp[startIndex+1][endIndex-1];
                }else{
                    // if not match
                    // then just get from start to end -1 or start+1 to end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex][endIndex-1], dp[startIndex+1][endIndex]);
                }
            }
        }
        return dp[0][len-1];
    }
}