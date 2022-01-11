class Solution {    
    public List<List<String>> partition(String s) {
        List<List<String>> palindromeList = new ArrayList<>();
        List<String> palindromeChars = new ArrayList();
        searchForPalindromes(palindromeList, palindromeChars, s);
        return palindromeList;
    }
    
    public void searchForPalindromes(List<List<String>> palindromeList, List<String> palindromeChars, String s) {
        //If this is a palindrome, add the partitioned palindromes to the result list
        if (validatePalindrome(s)) {
            List<String> result = new ArrayList<String>(palindromeChars);
            result.add(s);
            palindromeList.add(result);
        }
        //Iterate through each string character and determine partitions at this index
        for (int i = 1; i < s.length(); i++) {
            //Partition the string by character i
            String s1 = s.substring(0, i); 
            String s2 = s.substring(i, s.length());
            //If this is a palindrome, then add the substring to the list and move to the next character
            if (validatePalindrome(s1)) {
                List<String> list = new ArrayList<String>(palindromeChars);
                list.add(s1);
                searchForPalindromes(palindromeList, list, s2);
            }
        }
    }
    
    private boolean validatePalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}