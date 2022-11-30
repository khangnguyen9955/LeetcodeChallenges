class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        if (needle.length() > haystack.length()){
            return -1;
        }
        if(haystack.length() == 0) return -1;
        for (int i =0;i<haystack.length();i++){
            if((i + needle.length()) > haystack.length() ) break;   
            for (int j = 0;j<needle.length();j++){
                    if(needle.charAt(j) != haystack.charAt(i+j)) break;
                    if(j == needle.length()-1) return i;
                }
            }   
       return -1;
    }
}