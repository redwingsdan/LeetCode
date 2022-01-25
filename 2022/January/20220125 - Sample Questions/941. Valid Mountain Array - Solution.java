class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        if (arr.length == 3) {
            return arr[1] > arr[0] && arr[1] > arr[2]; 
        }
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            if (arr[end] >= arr[end-1] && arr[start] >= arr[start+1]) {
                return false;
            }
            if (arr[end] < arr[end-1]) {
                end--;
            }
            if (arr[start] < arr[start+1]) {
                start++;
            }
        }
        if (start == end) {
            return start == 0 || start == arr.length-1 ? false : arr[start] > arr[start+1] && arr[start] > arr[start-1];
        }
        return true;
    }
}