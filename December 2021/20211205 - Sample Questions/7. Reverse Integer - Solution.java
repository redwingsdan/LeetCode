class Solution {
    public int reverse(int x) {
        int answer = 0;
        String str = String.valueOf(x);
        try {
            if (x < 0) {
                str = str.substring(1, str.length());
            }
            for (int i = 0; i < str.length(); i++) {
                String digit = str.charAt(i) + "";
                if (answer + Math.pow(10, i) * Integer.parseInt(digit) > 2147483647) {
                    answer = 0;
                } else {
                    answer += Math.pow(10, i) * Integer.parseInt(digit);
                }
            }
            if (x < 0) {
                answer *= -1;
            }
        } catch (ArithmeticException e) {
            answer = 0;
        }
        return answer;
    }
}