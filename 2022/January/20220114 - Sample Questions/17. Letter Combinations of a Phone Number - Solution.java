class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> characterMap = new HashMap<String, List<String>>();
        characterMap.put("2", Arrays.asList("a", "b", "c"));
        characterMap.put("3", Arrays.asList("d", "e", "f"));
        characterMap.put("4", Arrays.asList("g", "h", "i"));
        characterMap.put("5", Arrays.asList("j", "k", "l"));
        characterMap.put("6", Arrays.asList("m", "n", "o"));
        characterMap.put("7", Arrays.asList("p", "q", "r", "s"));
        characterMap.put("8", Arrays.asList("t", "u", "v"));
        characterMap.put("9", Arrays.asList("w", "x", "y", "z"));
        List<String> possibleMappings = new ArrayList<String>();
        //Iterate through each digit
        for (int i = 0; i < digits.length(); i++) {
            String character = digits.charAt(i) + "";
            List<String> chars = characterMap.get(character);
            int sizeBeforeDigit = possibleMappings.size();
            //For each of the characters associated with the digit, add them to the possible mappings
            for (int charIndex = 0; charIndex < chars.size(); charIndex++) {
                String charToAdd = chars.get(charIndex);
                //If there are no mappings, just add these digits
                //Otherwise create more mappings
                if (sizeBeforeDigit == 0) {
                   possibleMappings.add(charToAdd);
                } else {
                    //For each of the existing mappings, create a new mapping
                    for (int mappingIndex = 0; mappingIndex < sizeBeforeDigit; mappingIndex++) {
                        possibleMappings.add(possibleMappings.get(mappingIndex) + charToAdd);
                    }
                }
            }
            final int currentDigitCount = i+1;
            possibleMappings = possibleMappings.stream().filter(pm -> pm.length() >= currentDigitCount).collect(Collectors.toList());
        }
        return possibleMappings;
    }
}