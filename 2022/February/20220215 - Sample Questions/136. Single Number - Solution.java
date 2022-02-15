class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> foundNum = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            if (foundNum.get(nums[i]) != null) {
                foundNum.remove(nums[i]);
            } else {
                foundNum.put(nums[i], true);
            }
        }
        for (Integer key : foundNum.keySet()) {
            return key;
        }
        return 0;
    }
}