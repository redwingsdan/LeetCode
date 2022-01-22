class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> edges = new HashMap<Integer, HashMap<Integer, Integer>>();
        //Populated visited node map
        HashMap<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
        for (int i = 1; i <= n; i++) {
            visitedMap.put(i, false);
            edges.put(i, new HashMap<Integer, Integer>());
        }
        //Populate network map
        for (int i = 0; i < times.length; i++) {
            int[] travelTime = times[i];
            int source = travelTime[0];
            int target = travelTime[1];
            int timeToTravel = travelTime[2];
            edges.get(source).put(target, timeToTravel);
        }
        int maxTravelTime = getMaxTravelTimeToNode(visitedMap, edges, k);
        //If any node remains unvisited then not all nodes can receive the signal
        for (Integer key : visitedMap.keySet()) {
            if (!visitedMap.get(key)) {
                return -1;
            }
        }
        return maxTravelTime;
    }
    
    private int getMaxTravelTimeToNode(HashMap<Integer, Boolean> visitedMap, HashMap<Integer, HashMap<Integer, Integer>> edges, int currentNode) {
        int maxTravelTime = 0;
        List<List<Integer>> valuesToCheck = new ArrayList<List<Integer>>();
        valuesToCheck.add(Arrays.asList(currentNode, 0));
        //Start by checking the current node (0 travel time)
        while(valuesToCheck.size() > 0) {
            List<Integer> value = valuesToCheck.remove(0);
            //If the node has been visited then there has been a loop
            if (visitedMap.get(value.get(0))) {
                continue;
            }
            visitedMap.put(value.get(0), true);
            //Increment the max travel time
            maxTravelTime = Math.max(maxTravelTime, value.get(1));
            //For each connection to this node, add a path to check
            for (Integer key : edges.get(value.get(0)).keySet()) {
                //Path is the node and the time it took to get here + the node's travel time
                valuesToCheck.add(Arrays.asList(key, value.get(1) + edges.get(value.get(0)).get(key)));
            }
            //Sort the values by lowest travel time to minimize time
            Collections.sort(valuesToCheck, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> a, List<Integer> b) {
                    return a.get(1) - b.get(1);
                }
            });
        }
       return maxTravelTime;
    }
}