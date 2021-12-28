class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        String binResult = "";
        for (int i = 0; i < bin.length(); i++) {
            String character = bin.charAt(i) + "";
            if ("1".equals(character)) {
                binResult += "0";
            } else {
                binResult += "1";
            }
        }
        return Integer.parseInt(binResult, 2);
    }
}