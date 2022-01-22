class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] winStatus = new boolean[n + 1];
        //For each stone amount up to the target, determine win status
        for (int i = 0; i <= n; i++) {
            //Iterate through possible options of stones to remove
            int squareVal = 1;
            int stonesToRemove = 1;
            while (stonesToRemove <= i) {
                //Check the state you'll be in if we remove these stones
                //If the value is false that means that we can win in this state since
                //the other player will lose in that state
                if (!winStatus[i - stonesToRemove]) {
                    winStatus[i] = true;
                    break;
                }
                //Otherwise try another move
                squareVal++;
                stonesToRemove = squareVal * squareVal;
            }
        }
        return winStatus[n];
    }
}