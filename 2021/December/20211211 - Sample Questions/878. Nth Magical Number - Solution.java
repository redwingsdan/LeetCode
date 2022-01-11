class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1_000_000_007;
        int l = a / greatestCommonDenom(a, b) * b;

        long lo = 0;
        long hi = (long) n * Math.min(a, b);
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            // If there are not enough magic numbers below mi...
            if (mi / a + mi / b - mi / l < n) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return (int) (lo % MOD);
    }
    
    public int greatestCommonDenom(int x, int y) {
        if (x == 0) {
           return y; 
        }
        return greatestCommonDenom(y % x, x);
    }
}