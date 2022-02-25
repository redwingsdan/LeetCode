class Solution {
    public int compareVersion(String version1, String version2) {
        //Get the number of sections for each string
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        //Determine the longest section
        int max = Math.max(str1.length, str2.length);
        for (int i = 0; i < max; i++) {
            //Get the version number for each section (or 0 if NA)
            int num1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
            int num2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);
            //Sort negative if 2 > 1
            if (num1 < num2) {
                return -1;
            }
            //Sort positive if 1 > 2
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}