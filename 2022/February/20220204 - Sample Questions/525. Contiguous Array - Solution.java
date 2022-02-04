class Solution {
    public int findMaxLength(int[] nums) {       
        int[] totalZeros = new int[2 * nums.length + 1];
        Arrays.fill(totalZeros, -2);
        totalZeros[nums.length] = -1;
        int longest = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (totalZeros[count + nums.length] >= -1) {
                longest = Math.max(longest, i - totalZeros[count + nums.length]);
            } else {
                totalZeros[count + nums.length] = i;
            }

        }
        return longest;
    }
}
