class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int difference = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            //Add the current number with the pair that gets closest to the target
            int possibleSum = nums[i] + findPair(nums, target-nums[i], i+1);
            int possibleDiff = Math.abs(target-possibleSum);
            //If the difference between the target and the possible sum is the lowest
            //then use that value
            if (possibleDiff < difference) {
                difference = possibleDiff;
                closestSum = possibleSum;
            }
        }
        return closestSum;
    }
    
    private int findPair(int[] nums, int target, int startPointer){
        int endPointer = nums.length-1;
        int difference = Integer.MAX_VALUE;
        int possibleSum = Integer.MAX_VALUE;
        //Iterate through all possibilities in the sorted array
        while (startPointer < endPointer) {
            int diffFromTarget = Math.abs(nums[startPointer] + nums[endPointer] - target);
            //If the diff from target is the lowest, use it and set the values as the possible sum
            if (diffFromTarget < difference) {
                difference = diffFromTarget;
                possibleSum = nums[startPointer] + nums[endPointer];
            }
            //If the sum is too big, use a smaller number
            //Otherwise use a bigger number
            if (nums[startPointer] + nums[endPointer] > target) {
                endPointer--;
            } else {
                startPointer++;
            }
        }
        return possibleSum;
    }
}