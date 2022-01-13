class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        //Sort the start values
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int totalArrows = 1;
        int currentStart = points[0][0];
        int currentEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int xStart = points[i][0];
            int xEnd = points[i][1];
            //If this point ends before the current end, use this as the new cutoff
            if (xEnd < currentEnd) {
                currentEnd = xEnd;
            }
            //If the start of this point is after the current cutoff then we need another balloon
            //And to set the new endpoint for the next arrow
            if (xStart > currentEnd) {
                totalArrows++;
                currentEnd = xEnd;
            }
        }
        return totalArrows;
    }
}