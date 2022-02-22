class Solution {
    public int titleToNumber(String columnTitle) {
        int colNum = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int val = (int)columnTitle.charAt(i) - 64;
            colNum += Math.pow(26, columnTitle.length() - 1 - i) * val;
        }
        return colNum;
    }
}