class Solution {
    public int numberOfArithmeticSlices(int[] nums) {        
        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int totalSlices = 0;
        for (int i = 2; i < nums.length; i++) {
            //If the gap between the 2 sets of numbers is the same
            //Then increment the total slices
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = 1 + dp[i-1];
                totalSlices += dp[i];
            }
        }
        return totalSlices;
    }
}