class Solution {
    public boolean canReach(int[] arr, int start) {
        //If we're out of bounds then we cannot reach
        if (start < 0 || start >= arr.length || arr[start] == -1) {
            return false;
        }
        //If the starting index is 0, we can reach
        if (arr[start] == 0) {
            return true;
        }
        int indexVal = arr[start];
        arr[start] = -1;
        boolean forward = canReach(arr, start + indexVal);
        boolean backward = canReach(arr, start - indexVal);
        return forward || backward;
        
        /*
        boolean canReach = false;
        //Find all indexes with value of zero
        List<Integer> destinationIndexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                destinationIndexes.add(i);
            }
        }
        destinationIndexes = jumpHelper(arr, destinationIndexes, start);
        return destinationIndexes.contains(start);
        */
    }
    /*
    private List<Integer> jumpHelper(int[] arr, List<Integer> destinationIndexes, int start) {
        List<Integer> destinationIndexes2 = new ArrayList<>();
        //Find places that can get to any of the destination indexes
        for (int i = 0; i < arr.length; i++) {
            //Ignore the destinations as starting points
            if (destinationIndexes.contains(i)) {
                continue;
            }
            int forward = i + arr[i];
            //Check forward jump
            if (forward < arr.length && destinationIndexes.contains(forward)) {
                destinationIndexes2.add(i);
                if (i == start) {
                    return destinationIndexes2;
                }
            }
            int backward = i - arr[i];
            //Check backward jump
            if (backward >= 0 && destinationIndexes.contains(backward)) {
                destinationIndexes2.add(i);
                if (i == start) {
                    return destinationIndexes2;
                }
            }
        }
        boolean isNewIndex = false;
        //Check if theres a new index being added
        for (Integer index : destinationIndexes2) {
            if (!destinationIndexes.contains(index)) {
                isNewIndex = true;
            }
        }
        if (!isNewIndex) {
            return destinationIndexes;
        }
        destinationIndexes.addAll(destinationIndexes2);
        return jumpHelper(arr, destinationIndexes, start);
    }
    */
}