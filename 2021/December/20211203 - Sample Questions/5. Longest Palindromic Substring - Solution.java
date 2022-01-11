class Solution {
	/* Too slow for LeetCode */
    public String longestPalindrome(String s) {
        String palindrome = s.charAt(0) + "";
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if ((s.charAt(1) + "").equals(palindrome)) {
                palindrome += s.charAt(1) + "";
            }
            return palindrome;
        }
        String longestPalindrome = "";
        HashMap<String, Boolean> checkedPalindromes = new HashMap<String, Boolean>();
        for (int i = 0; i < s.length(); i++) {
            String value = s.charAt(i) + "";
            if (value.length() > longestPalindrome.length()) {
                if (checkedPalindromes.containsKey(value) && !checkedPalindromes.get(value)) {
                } else {
                    checkedPalindromes.put(value, false);
                    if (validatePalindrome(value)) {
                        checkedPalindromes.put(value, true);
                        longestPalindrome = value;
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                value = s.substring(j, i+1);
                if (checkedPalindromes.containsKey(value) && !checkedPalindromes.get(value)) {
                    continue;
                }
                if (value.length() > longestPalindrome.length() && (value.charAt(0) + "").equals(value.charAt(value.length() - 1) + "")) {
                    checkedPalindromes.put(value, false);
                    if (validatePalindrome(value)) {
                        checkedPalindromes.put(value, true);
                        longestPalindrome = value;
                    }
                }
            }
        }
        return longestPalindrome;
    }
    
    private boolean validatePalindrome(String s) {
        boolean isPalindrome = true;
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) + "").equals(s.charAt(s.length() - i - 1) + "")){
                return false;
            }
        }
        return isPalindrome;
    }
}