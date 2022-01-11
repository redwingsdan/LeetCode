class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int aPointer = a.length()-1;
        int bPointer = b.length()-1;
        String carry = "0";
        while (aPointer >= 0 || bPointer >= 0 || !carry.equals("0")) {
            String value = "";
            //Check carry bit first
            if (!carry.equals("0")) {
                carry = "0";
                if (value.equals("") || value.equals("0")) {
                    value = "1";
                } else if (value.equals("1")) {
                    value = "0";
                    carry = "1";
                }
            }
            //Check value of a
            if (aPointer >= 0) {
                String charA = a.charAt(aPointer) + "";
                if (value.equals("") || value.equals("0")) {
                    value = charA;
                } else if (value.equals("1")) {
                    if (charA.equals("0")) {
                        value = "1";
                    } else {
                        value = "0";
                        carry = "1";
                    }
                }
                aPointer--; 
            }
            //Check value of b
            if (bPointer >= 0) {
                String charB = b.charAt(bPointer) + "";
                if (value.equals("") || value.equals("0")) {
                    value = charB;
                } else if (value.equals("1")) {
                    if (charB.equals("0")) {
                        value = "1";
                    } else {
                        value = "0";
                        carry = "1";
                    }
                }
                bPointer--;
            }
            result = value + result;
        }
        return result;
        //return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}