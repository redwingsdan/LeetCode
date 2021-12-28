class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> sol = new ArrayList<>();
        //Sort to ensure that the start items in the intervals are in order
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int startInterval = intervals[0][0];
        int endInterval = intervals[0][1];
        //Iterate through each interval
        for (int i = 1; i < intervals.length; i++) {
            //If the new start is inside the previous interval then use the new max
            //Otherwise there's no overlap and we can add the previous interval and move our pointer
            if (intervals[i][0] <= endInterval) {
                endInterval = Math.max(endInterval, intervals[i][1]);
            } else {
                //Add the remaining interval and move to the next one
                sol.add(new int[]{ startInterval, endInterval });
                //Set the start and end intervals
                startInterval = intervals[i][0];
                endInterval = intervals[i][1];
            }
        }
        //Add the remaining start/end intervals
        sol.add(new int[]{ startInterval, endInterval });
        return sol.toArray(new int[0][]); 
    }
}