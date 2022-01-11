class Solution {
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }
    
    /*
    public boolean isMatch(String text, String pattern) {
        //Handle empty pattern case
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        //Check that the first characters match or the first character is a '.'
        boolean firstMatch = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        //Check that the next character is a '*' and there is more to the string
        //Otherwise move to the next character in the text and pattern
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            //If we have a '*', check that the text matches the rest of the pattern or the next characters also match the pattern
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    */
}