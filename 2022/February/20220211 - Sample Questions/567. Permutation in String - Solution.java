class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freqMap = new int[26];
        int[] permutationMap = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freqMap[s1.charAt(i) - 'a']++;
            permutationMap[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (hasMatch(freqMap, permutationMap)) {
                return true;
            }
            permutationMap[s2.charAt(i + s1.length()) - 'a']++;
            permutationMap[s2.charAt(i) - 'a']--;
        }
        return hasMatch(freqMap, permutationMap);
    }
    
    private boolean hasMatch(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}