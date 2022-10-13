class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
    
        Map<String, List<String> > map = new HashMap<>();
        for(String s : strs){
            char [] ca = new char [26]; // store 26 characters
            for( char c : s.toCharArray()){
                ca[c-'a']++; // "a" - "a" , "b" -"a" technique
            }
            String key = String.valueOf(ca); // get the value of ca as a key
            if(!map.containsKey(key)) map.put(key,new ArrayList<>()); 
            // if this key is not exist in the map we put it into
            // if this key is exist in map, just add new value 
            map.get(key).add(s);
            
        }    
       return new ArrayList<>(map.values()); 
    }
}