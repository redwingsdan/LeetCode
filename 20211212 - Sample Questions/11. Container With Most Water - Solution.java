class Solution {
    public int maxArea(int[] height) {
        //Only 2 heights, use the lower one and a width of 2
        if (height.length == 2) {
            return Math.min(height[0], height[1]) * 1;
        }
        int area = 0;
        int start = 0;
        int end = height.length - 1;
        //Iterate through each item and calulate the highest area
        while (start < end) {
            int currentArea = Math.min(height[start], height[end]) * Math.abs(end - start);
            if (currentArea > area) {
                area = currentArea;
            }
            
            if (height[start] > height[end]) {
                end--;
            }
            else {
                start++;
            }
        }
        return area;
    }
}