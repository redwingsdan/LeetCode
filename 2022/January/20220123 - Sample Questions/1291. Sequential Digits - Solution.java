class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        int minLength = (low + "").length();
        int maxLength = (high + "").length();
        List<Integer> answers = new ArrayList<Integer>();
        for (int totalDigits = minLength; totalDigits <= maxLength; totalDigits++) {
            for(int digit = 0; digit < 10 - totalDigits; digit++){
                int possibleAnswer = Integer.parseInt(digits.substring(digit, digit + totalDigits));
                if (possibleAnswer >= low && possibleAnswer <= high) {
                    answers.add(possibleAnswer);
                }
            }
        }
        return answers;
    }
}