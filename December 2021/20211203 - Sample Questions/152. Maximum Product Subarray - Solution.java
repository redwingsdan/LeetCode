class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int answer = nums[0];
        int highestProduct = nums[0];
        int lowestNegative = nums[0];
        //Iterate through all of the numbers
        for (int i = 1; i < nums.length; i++) {
            int temp = highestProduct;
            //Store the max value of the highest product (positive or negative) or the current value
            highestProduct = Math.max(Math.max(highestProduct * nums[i], lowestNegative * nums[i]), nums[i]);
            //Store the lowest value in case there are double negative multiplications
            lowestNegative = Math.min(Math.min(temp * nums[i], lowestNegative * nums[i]), nums[i]);
            if (highestProduct > answer) {
                answer = highestProduct;
            }
        }
        return answer;

    }
}