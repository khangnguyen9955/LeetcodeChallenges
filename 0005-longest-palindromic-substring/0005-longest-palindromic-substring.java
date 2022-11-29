class Solution {
    public String longestPalindrome(String str) {
        int start = 0;
        int end = 0;
        for (int i =0 ; i < str.length(); i++){
            int oddComparation = expandAroundCenter(str,i,i);
            int evenComparation = expandAroundCenter(str, i, i+1);
            int max = Math.max(oddComparation, evenComparation);
            // this use to store the index of the longest palindromic substring
            // the max is just the max between 2 last comparations
            if(max > end-start){
                // since the i will always be the middle of the substring
                    start = i - (max-1)/2;                
                    end = i + max/2;
            }
        }
                    return str.substring(start,end+1);
    }
    private int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}