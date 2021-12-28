class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        // handle base case scenarios (1 and 2)
        if (n <= 2) {  
            return n;
        }
        // fullCovers[i]: number of ways to "fully cover a board" of width i
        long[] fullCovers = new long[n+1];  
        // fullCovers[i]: number of ways to "partially cover a board" of width i
        long[] partialCovers = new long[n+1];  
        // initialize full and partial covers with results for the base case scenarios
        fullCovers[1] = 1L;
        fullCovers[2] = 2L;
        partialCovers[2] = 1L;
        //Start with n = 3
        for (int i = 3; i <= n; ++i) {
            //Ways to fully cover board is the previous 2 amounts plus 2*the previous partial amount
            fullCovers[i] = (fullCovers[i - 1] + fullCovers[i - 2] + 2 * partialCovers[i - 1]) % MOD;
            //Wayst to partially cover board is the previous partial amount plus the 2nd previous full amount
            partialCovers[i] = (partialCovers[i - 1] + fullCovers[i - 2]) % MOD;
        }
        return (int) (fullCovers[n]);
    }
}