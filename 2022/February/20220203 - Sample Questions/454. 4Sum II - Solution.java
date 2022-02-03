class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int tuples = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                //Add a sum instance for each combination of 2 numbers
                if (sumMap.get(nums1[i] + nums2[j]) == null) {
                    sumMap.put(nums1[i] + nums2[j], 0);
                }
                sumMap.put(nums1[i] + nums2[j], sumMap.get(nums1[i] + nums2[j]) + 1);
            }
        }
        
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int expectedSumKey = -(nums3[i] + nums4[j]);
                //If there's a combo that adds up to these numbers, increment the tuples count
                if (sumMap.containsKey(expectedSumKey)) { 
                    tuples += sumMap.get(expectedSumKey);
                }
            }
        }
            
        return tuples;
    }
}