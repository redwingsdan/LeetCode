class StreamChecker {
    Trie root;
    int characterCount;
    char[] history;
    public StreamChecker(String[] words) {
        //Init properties
        this.root = new Trie();
        this.characterCount = 0; //0 characters at the start
        this.history = new char[2000]; //2000 words max
        //Add all words to the trie
        for (String word : words) {
            Trie curr = this.root;
            //Add words in reverse order
            for (int i = word.length() - 1; i >= 0; i--) {
                //If the next node's letter is missing, create a new entry at the letter's index
                if (curr.next[word.charAt(i) - 'a'] == null) {
                    curr.next[word.charAt(i) - 'a'] = new Trie();
                }
                curr = curr.next[word.charAt(i) - 'a'];
            }
            curr.isWord = true;
        }
    }
    
    public boolean query(char letter) {
        this.history[characterCount % 2000] = letter; //Add this character to the history
        Trie curr = root;
        boolean match = false;
        //Iterate through all characters in the history or until there is a match
        for (int i = 0; i < 2000 && !match; i++) {
            //Get the character from history
            char curChar = history[(characterCount - i + 2000) % 2000];
            if (curChar == 0) {
                break;
            }
            //If there are no further characters then break because there's no match here
            if (curr.next[curChar - 'a'] == null) {
                break;
            }
            //Otherwise get the next node and see if it is a word
            curr = curr.next[curChar - 'a'];
            match = curr.isWord;
        }
        characterCount++; //Iterate the count since we have checked this letter
        return match;
    }
    
    class Trie {
        boolean isWord;
        Trie[] next;
        
        public Trie() {
            this.next = new Trie[26]; //26 letters
            this.isWord = false; //Does this node represent a word
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */