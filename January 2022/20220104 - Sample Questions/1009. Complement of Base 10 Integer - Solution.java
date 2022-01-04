class Solution {
    public int bitwiseComplement(int n) {
		//If n is 0 then 1 is the opposite
		//Otherwise take the not value of the n and xor it with all ones
		//0s become 1 (0 & 1) == 1 and 1s become 0 (1 & 1) == 0
        return n == 0 ? 1 : ~n & Integer.highestOneBit(n) - 1;
    }
}