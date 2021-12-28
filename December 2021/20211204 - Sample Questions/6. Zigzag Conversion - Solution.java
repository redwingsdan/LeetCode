class Solution {
    public String convert(String s, int numRows) {
        /*
        int totalRows = numRows;
        int totalCols = (int)Math.ceil(s.length()/numRows);
        int stringIndex = 0;
        String[][] displayArr = new String[totalRows][totalCols];
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (stringIndex >= s.length()) {
                    displayArr[i][j] = "";
                } else if (j % (totalRows-i+1) == 0) {
                    displayArr[i][j] = s.charAt(stringIndex) + "";
                    stringIndex++;
                } else {
                    displayArr[i][j] = "";
                }
            }
        }
        System.out.println(Arrays.deepToString(displayArr));
        String result = "";
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (!displayArr[i][j].equals("")) {
                    result += displayArr[i][j];
                }
            }
        }
        
        return result;
        */
        
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) { // vertically down
                sb[idx].append(c[i++]);
            }
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) { // obliquely up
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}