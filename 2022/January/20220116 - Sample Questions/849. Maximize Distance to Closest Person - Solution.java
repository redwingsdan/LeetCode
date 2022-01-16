class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        for (int i = 0; i < seats.length; i++) {
            int currentDistance = 0;
            //If the seat is occupied, reset the count
            if (seats[i] == 1) {
                continue;
            }
            int forwardPointer = i;
            int backwardPointer = i;
            //If the seat is not occupied, determine the closest distance to an occupied seat
            while (seats[backwardPointer] != 1 && seats[forwardPointer] != 1 && (backwardPointer != 0 || forwardPointer != seats.length-1)) {
                currentDistance++;
                if (backwardPointer > 0) {
                    backwardPointer--;
                }
                if (forwardPointer < seats.length-1) {
                    forwardPointer++;
                }
            }
            //If the current distance is the most then update it
            maxDistance = Math.max(maxDistance, currentDistance);
        }
        return maxDistance;
    }
}