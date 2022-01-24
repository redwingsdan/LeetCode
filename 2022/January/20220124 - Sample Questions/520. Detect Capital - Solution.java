class Solution {
    public boolean detectCapitalUse(String word) {
		//One letter words are always valid
        if (word.length() == 1) {
            return true;
        }
		//Get the capitals for the 1st and 2nd letters
        boolean isFirstCapital = Character.isUpperCase(word.charAt(0));
        boolean isSecondCapital = Character.isUpperCase(word.charAt(1));
		//If the first is lowercase and the second is upper, we know its not valid
        if (!isFirstCapital && isSecondCapital) {
            return false;
        }
		//The expected capitalization is whatever the second letter is (all lowercase or all uppercase)
        boolean expectedCapital = isSecondCapital;
		//Iterate through the rest of the letters to see if any letters don't match the expected capitalization
        for (int i = 2; i < word.length(); i++) {
            boolean isCapital = Character.isUpperCase(word.charAt(i));
			//If the capitalization doesn't match the expected then return false
            if (expectedCapital != isCapital) {
                return false;
            }
        }
        return true;
    }
}