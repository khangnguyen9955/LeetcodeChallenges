class Solution {
    public int characterReplacement(String s, int k) {
        int [] count = new int[26]; // 26 characters
        int maxFreq= 0;
        int startPointer = 0;
        int max = 0;
        for(int endPointer = 0 ; endPointer < s.length(); endPointer++){
            if(endPointer - startPointer + 1 <= max){
                break;
            }
            count[s.charAt(endPointer) - 'A']++;
            maxFreq= Math.max(maxFreq,  count[s.charAt(endPointer)-'A']);
            if(endPointer - startPointer + 1 - maxFreq > k ) {
                // winSize - maxFreq must <= k (valid)
                count[s.charAt(startPointer)-'A']--; 
                // minus counter of the char in window
                startPointer++;

            }
            max = Math.max(max,endPointer-startPointer+1);
        }
        return max;
    }
}