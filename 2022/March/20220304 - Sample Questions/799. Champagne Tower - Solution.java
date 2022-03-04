class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102]; //100 rows + 1
        tower[0][0] = (double) poured;  //get the value of the first glass in the pyramid
        //For each row of glasses
        for (int row = 0; row <= query_row; row++) {
            //For each column of glasses (1 glass added for each row)
            for (int col = 0; col <= row; col++) {
                //get the overflow and divide by 2 (overflow on 2 sides)
                double overflow = (tower[row][col] - 1.0) / 2.0;
                //If there is overflow, then add the overflow to each glass on the level below (on each side)
                if (overflow > 0) {
                    tower[row+1][col] += overflow;
                    tower[row+1][col+1] += overflow;
                }
            }
        }
        //Find the overflow for the glass in question (1 means full glass)
        return Math.min(1, tower[query_row][query_glass]);
    }
}