class Solution {
    public int lengthOfLongestSubstring(String s) {
        String longestSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            String substring = getLongestSubstringFromIndex(i, s);
            if (longestSubstring.length() < substring.length()) {
                longestSubstring = substring;
            }
        }
        
        return longestSubstring.length();
    }
    
    private String getLongestSubstringFromIndex(int startingIndex, String s) {
        HashMap<String, String> charMap = new HashMap<String, String>();
        String substring = "";
        for (int i = startingIndex; i < s.length(); i++) {
            String character = s.charAt(i) + "";
            if (charMap.containsKey(character)) {
                break;
            }
            charMap.put(character, character);
            substring += character;
        }
        return substring;
    }
}