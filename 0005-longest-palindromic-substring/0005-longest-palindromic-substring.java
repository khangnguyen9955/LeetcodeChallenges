class Solution {
    public String longestPalindrome(String s) {
        int start = 0 ;
        int end = 0;

        for(int i = 0 ;i < s.length();i++){
            // now we will check even and odd 
            // b a b
            int odd = expandToLeftAndRight(s, i,i);
            // baab
            int even = expandToLeftAndRight(s,i,i+1);
            int max = Math.max(odd,even);
            if (max > end -start){
                // since our i will always be the middle index
                start = i - (max-1)/2;
                end =  i + max/2;
            }
        }
        return s.substring(start,end+1);


    }
    public int expandToLeftAndRight(String str, int left, int right){
        while ( left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
            // expand
        }
        return right-left-1;
    }
    
}
    