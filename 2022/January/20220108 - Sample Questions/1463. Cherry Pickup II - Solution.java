class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] predictor = new int[rows][cols][cols];
        //Fill in all values with -1 (since min is 0)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    predictor[i][j][k] = -1;
                }
            }
        }
        return findMax(0, 0, cols-1, grid, predictor);
    }
    
    private int findMax(int row, int robot1Col, int robot2Col, int[][] grid, int[][][] predictor) {
        //Determine out of bounds conditions
        if (robot1Col < 0 || robot1Col >= grid[0].length || robot2Col < 0 || robot2Col >= grid[0].length) {
            return 0;
        }
        //If checked, return the value
        if (predictor[row][robot1Col][robot2Col] != -1) {
            return predictor[row][robot1Col][robot2Col];
        }
        //Otherwise find the value for the cell
        int maxCherries = 0;
        maxCherries += grid[row][robot1Col];
        //Only count the second robot cherries if on a different column
        if (robot1Col != robot2Col) {
            maxCherries += grid[row][robot2Col];
        }
        //If we are not in the last row then move to the next row
        if (row != (grid.length - 1)) {
            int maxForRow = 0;
            //Check all 3 movement options for robot 1
            for (int newRobot1Col = robot1Col-1; newRobot1Col <= robot1Col+1; newRobot1Col++) {
                //Check all 3 movement options for robot 2
                for (int newRobot2Col = robot2Col-1; newRobot2Col <= robot2Col+1; newRobot2Col++) {
                    maxForRow = Math.max(maxForRow, findMax(row + 1, newRobot1Col, newRobot2Col, grid, predictor));
                }
            }
            maxCherries += maxForRow;
        }
        //Save the max for this row
        predictor[row][robot1Col][robot2Col] = maxCherries;
        return maxCherries;
    }
}