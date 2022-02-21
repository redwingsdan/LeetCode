class Solution {
    public int majorityElement(int[] nums) {
        int max = -1;
        int maxCount = 0;
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (countMap.get(nums[i]) == null) {
                countMap.put(nums[i], 0);
            }
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
            if (countMap.get(nums[i]) > maxCount) {
                max = nums[i];
                maxCount = countMap.get(nums[i]);
            }
        }
        return max;
		
		/* Boyer-Moore Voting Algorithm
		int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
		*/
    }
}