class Solution {
    public int subarraySum(int[] nums, int k) {
        int totalMatches = 0;
        int runningSum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        sumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (sumMap.get(runningSum-k) != null) {
                totalMatches += sumMap.get(runningSum-k);
            }
            if (sumMap.get(runningSum) == null) {
                 sumMap.put(runningSum, 0);
            }
            sumMap.put(runningSum, sumMap.get(runningSum) + 1);
        }
        return totalMatches;
    }
}