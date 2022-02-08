class Solution {
    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
        
        while (num >= 10) {
            int sum = 0;
            for (int i = 0; i < String.valueOf(num).length(); i++) {
                sum += Integer.parseInt(String.valueOf(num).charAt(i) + "");
            }
            num = sum;
        }
        return num;
    }
}