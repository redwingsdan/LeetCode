class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> numSet = new TreeSet<>();
        
        //Add each number to the set
        for (int num : nums) {
            numSet.add(num);
        }
        //Get the current min diff
        int minDiff = numSet.last() - numSet.first();
        
        //Perform all of the odd multiplications on the smallest numbers
        while (numSet.first() % 2 == 1) {
            //Multiply this min and replace it
            numSet.add(numSet.first() * 2);
            numSet.remove(numSet.first());
            //Calculate the new min diff
            minDiff = Math.min(minDiff, numSet.last() - numSet.first());
        }

        //Perform all of the even divisions
        while (numSet.last() % 2 == 0) {
            //Divide this max and replace it
            numSet.add(numSet.last() / 2);
            numSet.remove(numSet.last());
            //Calculate the new min diff
            minDiff = Math.min(minDiff, numSet.last() - numSet.first());
        }  
        return minDiff;
    }
}