class Solution {
    public boolean canPartition(int[] nums) {
        int totalSumInArray = 0;
        //Get total sum in array and divide by 2 (value for each array)
        for (int num : nums) {
            totalSumInArray += num;
        }
        //If odd number then can't split evenly
        if (totalSumInArray % 2 != 0 ) {
           return false; 
        }
        int subArrayTotal = totalSumInArray / 2;
        
        Set<Integer> totalsSet = new HashSet();
        totalsSet.add(0);
        //Iterate through each number
        for (int num : nums) {
            Set<Integer> tempTotalSet = new HashSet<Integer>(totalsSet);
            //Iterate through each tota; and add them to the sub array sets
            for (Integer totalSet : tempTotalSet) {
                //If adding this number gets the sub array to the subArrayTotal, then theres a match
                if (totalSet + num == subArrayTotal) {
                    return true;
                }
                //If adding this number doesn't put the set over the subArrayTotal, then add it
                if (totalSet + num < subArrayTotal) {
                   totalsSet.add(totalSet + num); 
                }
            } 
        }
        return false;
    }
}