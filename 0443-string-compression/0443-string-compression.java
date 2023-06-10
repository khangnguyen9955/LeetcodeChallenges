class Solution {
    public int compress(char[] chars) {
        int index =0;
        int loopIndex = 0;
        while ( index < chars.length){
            char curChar = chars[index];
            int count = 0; // count every char
            while(index < chars.length && chars[index] == curChar){
                count++;
                index++;
            }// keep counting if same char
            chars[loopIndex] = curChar; // reassign char to the original chars
            loopIndex++;
            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    // cast count into string
                    // then cast string to char arr
                    // then assign each char digit into original chars
                    chars[loopIndex] = c;
                    loopIndex++;
                }
            }
        }
        return loopIndex;
    }
}