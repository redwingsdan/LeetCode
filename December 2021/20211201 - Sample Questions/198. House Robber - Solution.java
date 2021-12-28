class Solution {
    public int rob(int[] nums) {
        int totalHouses = nums.length;
        int robberyTotals[] = new int[totalHouses];
        robberyTotals[0] = nums[0];
        
        //One house to rob
        if (nums.length == 1) {
            return nums[0];
        }
        //Compare the 2 houses
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //Either rob both end houses or the middle one
        if (nums.length == 3) {
            int middleHouse = nums[1];
            int endHouses = nums[0] + nums[2];
            return Math.max(middleHouse, endHouses);
        }
        
        robberyTotals[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < totalHouses; i++) {
            //Either rob this house with the next non-adjacent neighbor, or rob the neighbor
            robberyTotals[i] = Math.max(nums[i] + robberyTotals[i-2], robberyTotals[i-1]);
        }
        //Return the sum
        return robberyTotals[totalHouses-1];
    }
}