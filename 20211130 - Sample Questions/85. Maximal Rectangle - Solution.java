class Solution {
    public int maximalRectangle(char[][] matrix) {
        /*
        int maxRect = 0;
        //Iterate through all rows
        for (int i = 0; i < matrix.length; i++) {
            //Iterate through all columns
            for (int j = 0; j < matrix[i].length; j++) {
                //If the cell has a 1, determine the biggest rectangle it is part of
                if (matrix[i][j] == '1') {
                    maxRect = countHelper(maxRect, matrix, i, j);
                }
                //If the cell has a 0, move to the next cell
            }
        }
        return maxRect;
        */
        return realSolution(matrix);
    }
    
    private int realSolution(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int result = 0;
        for (char[] aMatrix : matrix) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (aMatrix[j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                    height[j]++;
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                    height[j] = 0;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (aMatrix[j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }
    
    private int countHelper(int maxRectangle, char[][] matrix, int rowIndex, int colIndex) {
        int currentWidth = 0;
        int currentHeight = 0;
        
        int maxWidth = matrix[0].length;
        
        for (int i = rowIndex; i < matrix.length; i++) {
            //Iterate through all columns
            for (int j = colIndex; j < maxWidth; j++) {
                System.out.println(matrix[i][j]);
                //If the cell has a 1, determine the biggest rectangle it is part of
                if (matrix[i][j] == '1') {
                    if (currentWidth < (j - colIndex + 1)) {
                        currentWidth = (j - colIndex + 1);
                    }
                    if (currentHeight < (i - rowIndex + 1)) {
                        currentHeight = (i - rowIndex + 1);
                    }
                } else {
                    //If the cell has a 0, move to the next row
                    maxWidth = j;
                }
            }
        }
        
        int newSize = currentWidth * currentHeight;
        System.out.println("Done");
        //If the new rectangle is bigger than the previous max, then use it as the new max
        if (maxRectangle < newSize) {
            maxRectangle = newSize;
        }
        return maxRectangle;
    }
}