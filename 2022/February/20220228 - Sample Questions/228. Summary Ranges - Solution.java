class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answers = new ArrayList<String>();
        if (nums.length == 0) {
            return answers;
        }
        if (nums.length == 1) {
            answers.add(nums[0] + "");
            return answers;
        }
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (numbers.get(numbers.size() - 1).equals(num-1)) {
                numbers.add(num);
            } else {
                String answer = "";
                if (numbers.size() == 1) {
                    answer = numbers.get(0) + "";
                } else {
                    answer = numbers.get(0) + "->" + numbers.get(numbers.size()-1);
                }
                answers.add(answer);
                numbers.clear();
                numbers.add(num);
            }
        }
        if (numbers.size() > 0) {
            String answer = "";
            if (numbers.size() == 1) {
                answer = numbers.get(0) + "";
            } else {
                answer = numbers.get(0) + "->" + numbers.get(numbers.size()-1);
            }
            answers.add(answer);
        }
        return answers;
    }
}