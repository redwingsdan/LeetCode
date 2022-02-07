class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
        char addedChar = 'a';
        for (int i = 0; i < t.length(); i++) {
            if (i < t.length()-1) {
                char character = s.charAt(i);
                if (letterCount.get(character) == null) {
                    letterCount.put(character, 0);
                }
                letterCount.put(character, letterCount.get(character) + 1);
            }
            
            char character = t.charAt(i);
            if (letterCount.get(character) == null) {
                letterCount.put(character, 0);
            }
            letterCount.put(character, letterCount.get(character) - 1);
        }
        
        for (char letter : letterCount.keySet()) {
            if (letterCount.get(letter) != 0) {
                return letter;
            }
        }
        return addedChar;
    }
}