class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length; 
        int cols = matrix[0].length;
        int[][] lengths = new int[rows + 1][cols + 1];
        int maxLength = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    lengths[i][j] = Math.min(Math.min(lengths[i][j - 1], lengths[i - 1][j]), lengths[i - 1][j - 1]) + 1;
                    maxLength = Math.max(maxLength, lengths[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}