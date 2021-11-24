class Solution {
    public int searchInsert(int[] nums, int target) {
        return getIndexHelper(0, nums.length, nums, target);
    }

    private int getIndexHelper(int lowIndex, int highIndex, int[] nums, int target) {
        int midpoint = (lowIndex + highIndex)/2;
        if (midpoint >= nums.length) { 
            return midpoint;
        }
        if (lowIndex > highIndex) {
            return lowIndex;
        }
        if (nums[midpoint] > target) {
            return getIndexHelper(lowIndex, midpoint-1, nums, target);
        } else if (nums[midpoint] < target) {
            return getIndexHelper(midpoint+1, highIndex, nums, target);
        }
        return midpoint;
    }
}