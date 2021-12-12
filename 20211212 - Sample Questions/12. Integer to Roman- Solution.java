class Solution {
    public String intToRoman(int num) {
       
        String romanNumerals = "";
        while (num > 0) {
            //Handle M
            while (num >= 1000) {
                romanNumerals += "M";
                num -= 1000;
            }
            while (num >= 900) {
                romanNumerals += "CM";
                num -= 900;
            }
            //Handle D
            while (num >= 500) {
                romanNumerals += "D";
                num -= 500;
            }
            while (num >= 400) {
                romanNumerals += "CD";
                num -= 400;
            }
            //Handle C
            while (num >= 100) {
                romanNumerals += "C";
                num -= 100;
            }
            while (num >= 90) {
                romanNumerals += "XC";
                num -= 90;
            }
            //Handle L
            while (num >= 50) {
                romanNumerals += "L";
                num -= 50;
            }
            while (num >= 40) {
                romanNumerals += "XL";
                num -= 40;
            }
            //Handle X
            while (num >= 10) {
                romanNumerals += "X";
                num -= 10;
            }
            while (num >= 9) {
                romanNumerals += "IX";
                num -= 9;
            }
            //Handle V
            while (num >= 5) {
                romanNumerals += "V";
                num -= 5;
            }
             while (num >= 4) {
                romanNumerals += "IV";
                num -= 4;
            }
            //Handle I
            while (num >= 1) {
                romanNumerals += "I";
                num -= 1;
            }
        }
        return romanNumerals;
    }
}