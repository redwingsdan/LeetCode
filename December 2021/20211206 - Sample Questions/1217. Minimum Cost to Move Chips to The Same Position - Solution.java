class Solution {
    public int minCostToMoveChips(int[] position) {
        int numEven = 0;
        int numOdd = 0;
        //Determine the total number of chips on an odd/even position
        for (int i = 0; i < position.length; i++) {
            //Determine position using the values
            if (position[i] % 2 == 0) {
                numEven++;
            } else {
                numOdd++;
            }
        }
        //whichever has less contains the number we are moving
        //and the count of that is the cost
        return Math.min(numEven, numOdd);
    }
}