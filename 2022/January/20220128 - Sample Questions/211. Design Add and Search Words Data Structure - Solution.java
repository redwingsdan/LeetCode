/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 
 class WordDictionary {
    private HashMap<Integer, List<String>> wordLengthMap;

    public WordDictionary() {
        this.wordLengthMap = new HashMap<>();
    }

    public void addWord(String word) {
        if (!this.wordLengthMap.containsKey(word.length())) {
            this.wordLengthMap.put(word.length(), new ArrayList<String>());
        }
        this.wordLengthMap.get(word.length()).add(word);
    }

    public boolean search(String word) {
		//If there's no match for this word length then we have no match
		if (!this.wordLengthMap.containsKey(word.length())) {
			return false;
		}
		//Check each word that has been added
        for (String w : this.wordLengthMap.get(word.length())) {
			int index = 0;
			for (index = 0; index < word.length(); index++) {
				//. always matches
				if ('.' == word.charAt(index) || w.charAt(index) == word.charAt(index)) {
					continue;
				}
				break;
			}
			if (index == word.length()) {
				return true;
			}
        }
		return false;
    }
}