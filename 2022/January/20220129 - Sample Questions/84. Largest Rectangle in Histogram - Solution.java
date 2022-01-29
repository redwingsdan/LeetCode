class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
    		int start = i;
        	while (!stack.isEmpty() && (i == heights.length || heights[i] <= stack.peek()[0])) {
    			int[] h = stack.poll();
    			start = h[1];
    			res = Math.max(res, (i - start) * h[0]);
    		}
        	if (i != heights.length)
        		stack.offerFirst(new int[] {heights[i], start});
        }
        return res;
    }
}