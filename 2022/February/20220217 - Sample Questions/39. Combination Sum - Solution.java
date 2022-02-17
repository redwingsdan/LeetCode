class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        getSum(candidates, target, answer, 0, new ArrayList<Integer>());
        return answer;
    }
    
    private void getSum(int[] candidates, int target, List<List<Integer>> resultList, int start, List<Integer> possibleCandidate){
        //If the current sum is already greater than the target, ignore
        if (target < 0) {
            return;
        }
        //If the current sum matches the target, then add the options as a result
        if (target == 0) {
            resultList.add(new ArrayList<Integer>(possibleCandidate));
            return;
        }
        //Iterate through each candidate
        for (int i = start; i < candidates.length; i++) {
            //Update the target based on this number
            target -= candidates[i];
            //Add this number to the possible results list
            possibleCandidate.add(candidates[i]);
            //Check to see if this number can produce the target
            getSum(candidates, target, resultList, i, possibleCandidate);
            //Remove this number to the possible results list
            possibleCandidate.remove(possibleCandidate.size()-1);
            //Restore the target value
            target += candidates[i];
        }
    }
}