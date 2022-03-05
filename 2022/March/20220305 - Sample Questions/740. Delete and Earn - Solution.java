class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> numPointMap = new HashMap<Integer, Integer>();
        int maxNumber = 0;
        //Add nums to the map
        for (int num : nums) {
            //Max points is number * # instances of itself
            numPointMap.put(num, numPointMap.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        //Init points for 0 and 1 since those can't vary
        int[] pointsDp = new int[maxNumber + 1];
        pointsDp[1] = numPointMap.getOrDefault(1, 0);
        //Iterate through all the remaining numbers
        for (int num = 2; num < pointsDp.length; num++) {
            //Get the max points earned for the current number
            int maxGain = numPointMap.getOrDefault(num, 0);
            //Determine the max points by taking the max of the previous value or skipping and using this number
            //We can only do every other number since we delete num[i] 
            pointsDp[num] = Math.max(pointsDp[num - 1], pointsDp[num - 2] + maxGain);
        }
        
        return pointsDp[maxNumber];
    }
}