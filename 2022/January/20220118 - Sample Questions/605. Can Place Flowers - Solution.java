class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //Handle planting no flowers
        if (n == 0) {
            return true;
        }
        //If only 1 location, it works if its empty
        if (flowerbed.length == 1) {
            return n == 0 ? true : flowerbed[0] == 0;
        }
        //If only 2 locations, it works if we only want to plant 1 flower and both spots are empty
        if (flowerbed.length == 2) {
            return n == 2 ? false : flowerbed[0] == 0 && flowerbed[1] == 0;
        }
        int plantedFlowers = 0;
        int startPointer = 1;
        //Check if we can plant on the leftmost spot
        if (flowerbed[0] == 0 && flowerbed[startPointer] == 0) {
            flowerbed[0] = 1;
            plantedFlowers++;
        }
        int endPointer = flowerbed.length-2;
        //Check if we can plant on the rightmost spot
        if (flowerbed[flowerbed.length-1] == 0 && flowerbed[endPointer] == 0) {
            flowerbed[flowerbed.length-1] = 1;
            plantedFlowers++;
        }
        boolean canPlace = plantedFlowers >= n;
        //Iterate through both ends to find open spots
        while (startPointer <= endPointer) {
            //If we are at the same location, only check 1 pointer
            //Otherwise check if we can plant a flower at each pointer
            if (startPointer == endPointer) {
                if (flowerbed[startPointer-1] == 0 && flowerbed[startPointer] == 0 && flowerbed[startPointer+1] == 0) {
                    flowerbed[startPointer] = 1;
                    plantedFlowers++;
                    startPointer++;
                }
            } else {
                if (flowerbed[startPointer-1] == 0 && flowerbed[startPointer] == 0 && flowerbed[startPointer+1] == 0) {
                    flowerbed[startPointer] = 1;
                    plantedFlowers++;
                    startPointer++;
                }
                if (flowerbed[endPointer+1] == 0 && flowerbed[endPointer] == 0 && flowerbed[endPointer-1] == 0) {
                    flowerbed[endPointer] = 1;
                    plantedFlowers++;
                    endPointer--;
                }
            }
            startPointer++;
            endPointer--;
            //If we ever plant the goal then return true
            if (plantedFlowers >= n) {
                canPlace = true;
                break;
            }
        }
        return canPlace;
    }
}