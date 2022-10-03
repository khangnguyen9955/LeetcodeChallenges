class Solution {
 
    public int lengthOfLongestSubstring(String a) {
        if(a == null || a.length() == 0) return 0;
        HashMap< Character,Integer> table = new HashMap<Character,Integer>();
        int max = Integer.MIN_VALUE;
        
        for(int i =0, j =0 ;i<a.length();i++){
            if(table.containsKey(a.charAt(i))){
                j = Math.max(j,table.get(a.charAt(i))+1);
            }
               table.put(a.charAt(i),i);
               max= Math.max(max,i-j+1);
            
            
        }
return max;




    
        
    }
}