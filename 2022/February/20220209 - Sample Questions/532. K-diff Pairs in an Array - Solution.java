class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> indexValMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (indexValMap.get(nums[i]) == null) {
               indexValMap.put(nums[i], 0);
            }
            indexValMap.put(nums[i], indexValMap.get(nums[i]) + 1);
        }
        int totalPairs = 0;
        for (Integer key : indexValMap.keySet()) {
            if ((k == 0 && indexValMap.get(key) > 1) ||
                (k > 0 && indexValMap.get(key - k) != null)
            ) {
                totalPairs++;
            }
        }
        return totalPairs;
    }
}