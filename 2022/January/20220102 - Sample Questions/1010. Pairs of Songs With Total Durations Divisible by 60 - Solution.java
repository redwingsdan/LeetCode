class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] matchesByMod60 = new int[60];
        for (int x = 0; x < 60; x++) {
           matchesByMod60[x] = 0;
        }
        //Determine number of items that have a particular mod value
        for (int i = 0; i < time.length; i++) {
            int modVal = time[i] % 60;
            matchesByMod60[modVal] = matchesByMod60[modVal] + 1;
        }
        int totalPairs = 0;
        //Find total permutations that sum to mod 60 = 0
        int i = 0;
        int j = 60;
        //Iterate through all the mod values and count the permutations
        while (i <= j) {
            int val1 = matchesByMod60[i];
            int val2 = j == 60 ? matchesByMod60[0] : matchesByMod60[j];
            if (i == j || j == 60) {
                if (val2 <= 1) {
                    val2 = 0;
                }
                //n(n-1)/2 for the set containing itself
                totalPairs += val2 <= 0 ? 0 : (val2 * (val2-1))/2;
            } else {
                //otherwise just multiply the matches together
                totalPairs += val1 * val2;
            }
            i++;
            j--;
        }
        return totalPairs;
    }
    
    public int bruteForce(int[] time) {
        int totalPairs = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = time.length-1; j > i; j--) {
                if ((time[i] + time[j]) % 60 == 0) {
                    totalPairs++;
                }
            }
        }
        return totalPairs;
    }
}