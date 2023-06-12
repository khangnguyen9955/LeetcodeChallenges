class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0 ) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        // map store {char : index } as {key : value}
        int max = Integer.MIN_VALUE;
        int startPointer= 0;
        for(int endPointer =0; endPointer < s.length(); endPointer++){
            if(map.containsKey(s.charAt(endPointer))){
                // update the startPointer position to the the right of duplicated character in our map 
                // for example
                //  "a" : 1 <= This is the startPointer currently (1)
                //  "b" : 2
                // then we found new "a" with index 3
                // => update startPointer to:
                // "b" : 2  <= New start pointer (2)
                startPointer = Math.max( startPointer ,map.get(s.charAt(endPointer))+1);
                // Example cases why use max():
                // "abba" 
            }
            map.put(s.charAt(endPointer), endPointer );
            max = Math.max(max, endPointer - startPointer + 1);
        }
        return max;
    }
}