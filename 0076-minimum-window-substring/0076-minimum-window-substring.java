class Solution {
    public String minWindow(String s, String t) {
    // initialize the array with index of every char in T has value +1; 
        int [] arr = new int [128];
        for(char c: t.toCharArray()){
            arr[c]++;
        }
    // slide window
        int windowStart = 0 ;
        int count = t.length();
        int minStart = 0; // store the start index
        int minLength = Integer.MAX_VALUE; // store the min length;
        for(int windowEnd = 0 ; windowEnd < s.length();windowEnd++){
             char c1 = s.charAt(windowEnd);
            // if we found that s.charAt(windowEnd) in T we minus count and minus that value in T by 1;
            if(arr[c1] > 0) count--;
            arr[c1]--;
            // valid 
            while (count == 0){
                // store the string 
                // store the length;
                if(minLength > windowEnd - windowStart + 1){
                    minLength = windowEnd - windowStart + 1;
                    minStart = windowStart;
                }
                // shrink
                char c2 = s.charAt(windowStart);
                arr[c2]++;
                // if that char is the char we need to find then our counter need to be plus 1 
                if( arr[c2] > 0) count++;
                windowStart++;
            }
            
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
         
    }
}