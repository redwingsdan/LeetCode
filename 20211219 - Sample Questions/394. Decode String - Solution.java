class Solution {
    public String decodeString(String s) {
        int[] i = {0}; // maintains the index we're at through out the recursion. 
        return decode(s, i);
    }
    
    public String decode(String s, int[] i){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(i[0] < s.length()){
            char ch = s.charAt(i[0]);
            i[0]++; 
            
            if(Character.isDigit(ch)){
                num = num * 10+ (ch -'0'); // if curr char is a number, store it
            }
            else if(ch == '['){
                String innerStr = decode(s, i); // start recursion to solve sub problem. Returns the string between [ and ].
                while(num != 0){ 
                    sb.append(innerStr); // multiply returned string with the num. 
                    num--; // num resets to 0.
                }
            }
            else if(ch == ']'){ // At this point, we're finishing up a recursive call. 
                break;  // break from the sub call and return innerString.
            }
            else{
                sb.append(ch); // appends any extra characters that do not need multiplying Ex: abc2[a], a2[b]a
            }
        }
        return sb.toString();
    }
    
    /*
        public String decodeString(String s) {
        String decoded = "";
        String[] nums = new String["1", "2", "3", "4", "5", "6", "7", "8", "9"];
        int index = 0;
        while (index < s.length()) {
            String character = s.charAt(index) + "";
            //If character is not a number
            if (!nums.contains(character)) {
                decoded += character;
            } else {
                String partialString = s.substring(index, s.length());
                String numberToParse = partialString.substring(0, partialString.indexOf("["));
                Integer numberOfChars = Integer.parseInt(numberToParse);
            }
        }
        return decoded;
    }
    */
}