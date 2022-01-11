class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
        boolean isAnagram = false;
        if (s.length() != t.length()) {
            return isAnagram;
        }
        for (int i = 0; i < s.length(); i++) {
            String character = s.charAt(i) + "";
            if (freqMap.get(character) == null) {
                freqMap.put(character, 0);
            }
            freqMap.put(character, freqMap.get(character) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            String character = t.charAt(j) + "";
            if (!freqMap.containsKey(character)) {
                return isAnagram;
            }
            freqMap.put(character, freqMap.get(character) - 1);
            if (freqMap.get(character) == 0) {
                freqMap.remove(character);
            }
        }
        
        if (freqMap.keySet().size() == 0) {
            isAnagram = true;
        }
        
        return isAnagram;
    }
}