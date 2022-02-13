class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        answer.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //Add the permutations with all numbers before it
            List<List<Integer>> answersToAdd = new ArrayList<List<Integer>>();
            for (List<Integer> permutation : answer) {
                List<Integer> copy = new ArrayList<>();
                copy.addAll(permutation);
                copy.add(num);
                answersToAdd.add(copy);
            }
            answer.addAll(answersToAdd);
        }
        return answer;
    }
}