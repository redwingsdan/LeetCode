class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        var maxDupes = 2;
        for (var i = maxDupes; i < nums.length; i++) {
            //If them item 2 spots back is not a dupe then move up the pointer and replace the value
            if (nums[i] != nums[maxDupes - 2]) {
                nums[maxDupes] = nums[i];
                maxDupes++;
            }
        }    
        return maxDupes;
    }
}