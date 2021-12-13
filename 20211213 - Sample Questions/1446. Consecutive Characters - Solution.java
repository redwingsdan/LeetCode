class Solution {
    public int maxPower(String s) {
        String previousChar = s.charAt(0) + "";
        int maxCount = 1;
        int newCount = 1;
        for (int i = 1; i < s.length(); i++) {
            String parsedChar = s.charAt(i) + "";
            if (previousChar.equals(parsedChar)) {
                newCount++;
            } else {
                maxCount = Math.max(maxCount, newCount);
                newCount = 1;
            }
            previousChar = parsedChar;
        }
        maxCount = Math.max(maxCount, newCount);
        return maxCount;
    }
}