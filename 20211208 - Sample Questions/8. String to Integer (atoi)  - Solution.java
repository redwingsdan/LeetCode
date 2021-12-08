class Solution {
    public int myAtoi(String s) {
        int answer = 0;
        if (s == null || s.length() == 0) {
            return answer;
        }
        int startIndex = 0;
        //Ignore whitespace
        s = s.trim();
        if (s == null || s.length() == 0) {
            return answer;
        }
        //Check if character indicates + or -
        String signCharacter = s.charAt(startIndex) + "";
        List<String> posNegCharacters = Arrays.asList("+", "-");
        boolean isNegative = false;
        if (posNegCharacters.contains(signCharacter)) {
            isNegative = "-".equals(signCharacter);
            startIndex++;
        }
        //Parse remainder of string
        List<String> numberCharacters = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        for (int i = startIndex; i < s.length(); i++) {
            String character = s.charAt(i) + "";
            int digit = s.charAt(i) - '0';
            //Iterate through all the characters
            //Stop if the character is not a number
            if (!numberCharacters.contains(character)) {
                return answer * (isNegative ? -1 : 1);
            }
            if (answer > (Integer.MAX_VALUE - digit) / 10){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            answer = (answer * 10) + digit;
        }
        return answer * (isNegative ? -1 : 1);
    }
}