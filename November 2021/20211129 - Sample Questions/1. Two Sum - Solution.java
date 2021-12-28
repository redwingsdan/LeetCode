class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sumArr = new int[2];
        int[] adderArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            adderArr[i] = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (i != j && nums[j] == adderArr[i]) {
                    sumArr[0] = i;
                    sumArr[1] = j;
                }
            }
        }
        return sumArr;
    }
}