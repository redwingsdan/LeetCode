class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] coinsByIndex = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += i == start ? 0 : coinsByIndex[start][i - 1]; // If not first one, we can add subrange on its left.
                    coins += i == end ? 0 : coinsByIndex[i + 1][end]; // If not last one, we can add subrange on its right
                    coinsByIndex[start][end] = Math.max(coinsByIndex[start][end], coins);
                }
            }
        }
        return coinsByIndex[0][nums.length - 1];
    }
    private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
        if (i < 0 || i >= nums.length) {
            return 1;
        }
        return nums[i];
    }
    
}