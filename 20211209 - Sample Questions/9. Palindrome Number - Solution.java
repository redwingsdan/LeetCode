class Solution {
    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        String str = x + "";
        for (int i = 0; i < str.length()-1; i++) {
            if (i >= str.length()-1 - i) {
                break;
            }
            String first = str.charAt(i) + "";
            String last = str.charAt(str.length()-1 - i) + "";
            if (!first.equals(last)) {
                return false;
            }
        }
        return isPalindrome;
    }
}