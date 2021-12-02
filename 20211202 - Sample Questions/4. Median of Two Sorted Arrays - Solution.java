class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Combine arrays
        int[] combinedNums = new int[nums1.length + nums2.length];
        int num1Index = 0;
        int num2Index = 0;
        int combinedNumsIndex = 0;
        //Iterate through all the arrays and start combining
        while (nums1.length > num1Index && nums2.length > num2Index) {
            //If the first array number is lower, add it first
            //Otherwise put the second array number in
            if (nums1[num1Index] < nums2[num2Index]) {
                combinedNums[combinedNumsIndex] = nums1[num1Index];
                num1Index++;
            } else {
                combinedNums[combinedNumsIndex] = nums2[num2Index];
                num2Index++;
            }
            combinedNumsIndex++;
        }
        //Add extra num1 items to the array
        while (nums1.length > num1Index) {
            combinedNums[combinedNumsIndex] = nums1[num1Index];
            num1Index++;
            combinedNumsIndex++;
        }
        //Add extra num2 items to the array
        while (nums2.length > num2Index) {
            combinedNums[combinedNumsIndex] = nums2[num2Index];
            num2Index++;
            combinedNumsIndex++;
        }
        
        //Determine median from combined array
        double median = 0.0;
        if (combinedNums.length == 1) {
            return (double)combinedNums[0];
        }
        if (combinedNums.length == 2) {
            return (double)(combinedNums[0] + combinedNums[1]) / 2;
        }
        //If there are even numbers then we need to sum the 2 medians and divide by 2
        if (combinedNums.length % 2 == 0) {
            median = (double)(combinedNums[(combinedNums.length/2) - 1] + combinedNums[combinedNums.length/2]) / 2;
        } else {
            median = combinedNums[combinedNums.length/2];
        }
        return median;
    }
}
