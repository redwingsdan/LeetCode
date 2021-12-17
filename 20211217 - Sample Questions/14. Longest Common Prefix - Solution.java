class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix = strs[0];
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //Update the prefix to be the min length of the next character
            prefix = prefix.substring(0, Math.min(prefix.length(), strs[i].length()));
            //Iterate through the minimum length of the current string and saved prefix
            for (int j = 0; j < Math.min(prefix.length(), strs[i].length()); j++) {
                String currentChar = strs[i].charAt(j) + "";
                String prefixChar = prefix.charAt(j) + "";
                //Break once the characters no longer match
                if (!currentChar.equals(prefixChar)) {
                    prefix = strs[i].substring(0, j);
                    continue;
                }
            }
            //If the new prefix is shorter than the existing longest, then update the longest
            if (prefix.length() < longestPrefix.length()) {
                longestPrefix = prefix;
            }
        }
        return longestPrefix;
    }
}