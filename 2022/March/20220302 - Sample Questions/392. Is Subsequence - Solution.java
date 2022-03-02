class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            String testCharacter = t.charAt(i) + "";
            String stringCharacter = s.charAt(index) + "";
            if (stringCharacter.equals(testCharacter)) {
                index++;
            }
            if (index >= s.length()) {
                return true;
            }
        }
        return false;
    }
}