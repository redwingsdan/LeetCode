class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] patternLetters = pattern.split("");
        String[] words = s.split(" ");
        if (patternLetters.length != words.length) {
            return false;
        }
        boolean followsPattern = true;
        HashMap<String, String> wordPatternMap = new HashMap<String, String>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //Initialize the word in the map if one doesn't already exist
            if (wordPatternMap.get(patternLetters[i]) == null) {
                wordPatternMap.put(patternLetters[i], word);
            }
            //If another key contains the value of this key, then we have a dupe
            for (String key : wordPatternMap.keySet()) {
                if (!key.equals(patternLetters[i]) && wordPatternMap.get(key).equals(word)) {
                    followsPattern = false;
                }
            }
            //If the expected word doesn't match the current word, then the pattern is broken
            if (!wordPatternMap.get(patternLetters[i]).equals(word)) {
                followsPattern = false;
            }
        }
        return followsPattern;
    }
}