class Solution {
    public int smallestRepunitDivByK(int k) {
        //All even numbers and numbers ending with 5 will never work
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int digits = 1;
        Integer dividend = 0;
        //Iterate through each digit up to k
        while (digits < k) {
            dividend = (dividend * 10) + 1;
            //check if divisible
            if (dividend % k == 0) {
                break;
            } else {
                dividend = dividend % k;
            }
            digits++;
        }
        return digits;
    }
}