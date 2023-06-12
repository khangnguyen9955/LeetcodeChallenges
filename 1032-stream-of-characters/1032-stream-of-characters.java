class StreamChecker {
    // build Trie data structure
    class Trie {
        public Trie[] children;
        public boolean endOfWord;
        public Trie(){
            children = new Trie [26]; // 26 unique letters
            endOfWord = false; // default is false
        }

        public void add(String s){
            Trie trie = this;
            for (char c : s.toCharArray()){ 
                // add every char to trie
                if(trie.children[c-'a'] == null){ // this trie not contain this char
                    trie.children[c-'a'] = new Trie(); // expand sub trie to our Trie
                }
                trie = trie.children[c-'a']; // move the position
                // for example "cd" 
                // move to "c" then we can add "d" into "c" trie
            }
            // then end of string we have to mark this last Trie as endofword
            trie.endOfWord = true;
        }

        public boolean search(Deque<Character> s ){
            // given a deque (2 side queue)
            Trie trie = this;
            // basically just loop through this queue until find endOfWord
            for(char c : s){
                if(trie.children[c-'a']== null) return false; 
                // the char is not matched then return false immediately
                // if match then move into that trie and check whether that is endOfWord?
                trie = trie.children[c-'a'];
                if(trie.endOfWord) return true;
            }
            return false;
        }

    } 
    public Trie trie = new Trie();
    public Deque<Character> stream = new LinkedList();
    public StreamChecker(String[] words) {
        for(String s : words){
                //initialize the "DB", build the trie
            String sReverse = new StringBuilder(s).reverse().toString();
            trie.add(sReverse);
        }
    }

    public boolean query(char letter){
        stream.addFirst(letter);
        // add every new character to front of the queue/
        // so we can start loop from the front of the queue with new character 
        // do not need to loop again and again 
        // we can also use a List and append to the last of list, then iterate backwards.
        return trie.search(stream);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */