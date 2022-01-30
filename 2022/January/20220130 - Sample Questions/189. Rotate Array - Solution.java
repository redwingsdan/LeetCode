class Solution {
    public void rotate(int[] nums, int k) {
        int[] answer = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            answer[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = answer[i];
        }
    }
}