class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            String character = s.charAt(i) + "";
            if ("M".equals(character)) {
                sum += 1000;
            } else if ("D".equals(character)) {
                sum += 500;
            } else if ("C".equals(character)) {
                if ((i+1) < s.length()) {
                    if ("D".equals(s.charAt(i+1) + "")){
                        sum += 400;
                        i++;
                    } else if ("M".equals(s.charAt(i+1) + "")) {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                } else {
                    sum += 100;
                }
            } else if ("L".equals(character)) {
                sum += 50;
            } else if ("X".equals(character)) {
                if ((i+1) < s.length()) {
                    if ("L".equals(s.charAt(i+1) + "")){
                        sum += 40;
                        i++;
                    } else if ("C".equals(s.charAt(i+1) + "")) {
                        sum += 90;
                        i++;
                    } else {
                        sum += 10;
                    }
                } else {
                    sum += 10;
                }
            } else if ("V".equals(character)) {
                sum += 5;
            } else if ("I".equals(character)) {
                if ((i+1) < s.length()) {
                    if ("V".equals(s.charAt(i+1) + "")){
                        sum += 4;
                        i++;
                    } else if ("X".equals(s.charAt(i+1) + "")) {
                        sum += 9;
                        i++;
                    } else {
                        sum += 1;
                    }
                } else {
                    sum += 1;
                }
            }
        }
        return sum;
    }
}