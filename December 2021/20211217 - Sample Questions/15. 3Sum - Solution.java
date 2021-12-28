class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tripletsSet = new ArrayList<>();
        if (nums.length < 3) {
            return tripletsSet;
        }
        //Sort to only account for negative numbers
        Arrays.sort(nums);
        //Create map of solutions that exist
        Set<List<Integer>> setMap = new HashSet<>();
        //Iterate through each number
        for (int i = 0; i < nums.length; i++) {
            //Once we pass 0, the next sum cannot add to 0
            if (nums[i] > 0) {
                break;
            }
            int target = -nums[i];
            int j = i+1;
            int k = nums.length-1;
            //Compare the 2 end numbers using dual pointers to meet the target
            while (j < k) {
                //If the numbers match the target, add it and move both pointers
                if (nums[j] + nums[k] == target) {
                    setMap.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > target) {
                    //Move the end pointer if the value is too high (highest number)
                    k--;
                } else {
                    //Move the start pointer if the value is too low (lowest number)
                    j++;
                }
            }
        }

        return new ArrayList(setMap);
    }
}