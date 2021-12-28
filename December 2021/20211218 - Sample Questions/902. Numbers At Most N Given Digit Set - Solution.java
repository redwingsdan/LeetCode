class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int numLength = String.valueOf(n).length();
        int totalNumbers = 0;
        //If we have 5 numbers and the number we're looking for has 3 digits, we can definitely make 25 (5^2) numbers that are less than it
        for (int i = 1; i < numLength; i++) {
            totalNumbers += (int)Math.pow(digits.length, i);
        }
        int[] allDigitNumbers = new int[numLength+1];
        allDigitNumbers[numLength] = 1;
        //Iterate through each number place
        for (int i = numLength-1; i >= 0; --i) {
            String numberChar = String.valueOf(n).charAt(i) + "";
            //For each digit in the number, determine which digits are less than that place
            for (int j = 0; j < digits.length; j++) {
                String digit = digits[j];
                //Handle when the digit is less (any other combination of digits works)
                if (Integer.parseInt(numberChar) > Integer.parseInt(digit)) {
                    allDigitNumbers[i] += (int)Math.pow(digits.length, numLength-i-1);
                }
                //Handle when the digits match, move to the next digit and determine number of matches
                else if (Integer.parseInt(numberChar) == Integer.parseInt(digit)) {
                    allDigitNumbers[i] += allDigitNumbers[i+1];
                }
            }
        }
        return totalNumbers + allDigitNumbers[0];
    }
}