class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = Arrays.asList(arr[0], arr[1]);
        results.add(result);
        for (int i = 2; i < arr.length; i++) {
            int tempDiff = arr[i] - arr[i-1];
            if (tempDiff < minDiff) {
                results = new ArrayList<>();
                result = Arrays.asList(arr[i-1], arr[i]);
                results.add(result);
                minDiff = tempDiff;
            } else if (tempDiff == minDiff) {
                result = Arrays.asList(arr[i-1], arr[i]);
                results.add(result);
            }
        }
        return results;
    }
}