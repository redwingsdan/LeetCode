class Solution {   
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); //sort the numbers
        return kSum(nums, target, 0, 4);
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> answers = new ArrayList<>();
        
        //If we have run out of numbers to add, return answers.
        if (start == nums.length) {
            return answers;
        }
        
        //There are k remaining values to add to the sum. The 
        //average of these values is at least target / k.
        int averageVal = target / k;
        
        //If the smallest value is too big or the largest value is too small
        //Then we know its not possible to meet the target
        if (nums[start] > averageVal || averageVal > nums[nums.length - 1]) {
            return answers;
        }
        
        if (k == 2) {
            return twoSum(nums, target, start);
        }
    
        //Iterate through all numbers
        for (int i = start; i < nums.length; i++) {
            //If this is the first number or the previous number is not the same as the current
            if (i == start || nums[i - 1] != nums[i]) {
                //Iterate through the answers from the the next position (new target, iterated start, and 1 less item)
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    //For each valid subset, add the current number to the list
                    answers.add(new ArrayList<>(Arrays.asList(nums[i])));
                    answers.get(answers.size() - 1).addAll(subset);
                }
            }
        }
        return answers;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> answers = new ArrayList<>();
        Set<Integer> sumSet = new HashSet<>();
    
        for (int i = start; i < nums.length; i++) {
            if (answers.isEmpty() || answers.get(answers.size() - 1).get(1) != nums[i]) {
                if (sumSet.contains(target - nums[i])) {
                    answers.add(Arrays.asList(target - nums[i], nums[i]));
                }
            }
            sumSet.add(nums[i]);
        }
                                                  
        return answers;
    }
}