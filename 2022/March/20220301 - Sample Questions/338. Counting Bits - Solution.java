class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int subtract = 1;
        for(int i = 1; i <= n; i++) {
            //Since this is base 2, when we're at a new significant digit we need to remove the 1s
            if (i == subtract * 2) {
                subtract = i;
            }
            //DP to use the previous answer (adding 1 for the new incremented number)
            ans[i] = ans[i - subtract] + 1;
        }
        return ans;
    }
}