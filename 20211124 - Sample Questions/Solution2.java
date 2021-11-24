class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinceCount = isConnected.length;
        int numConnections = 0;
        boolean[] visited = new boolean[provinceCount];
        for (int i = 0; i < provinceCount; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numConnections++;
                depthFirstSearch(isConnected, visited, i);
            }
        }
        return numConnections;
    }
    
    private void depthFirstSearch(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                depthFirstSearch(isConnected, visited, j);
            }
        }
    }
}