class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1; //min pile length
        int maxSpeed = 1000000000; //max pile length
        int speed = 0; //starting speed
        while (minSpeed <= maxSpeed) {
            speed = (minSpeed + maxSpeed) / 2; //average speed
            int currentSpeed = 0;
            //Iterate through each pile and determine the speed
            for (int i = 0; i < piles.length; i ++) {
                currentSpeed += Math.ceil(1.0 * piles[i] / speed);
            }
            //If the current speed is higher, move the pointer up
            //Otherwise move the pointer back
            if (currentSpeed > h) {
                minSpeed = speed + 1;
            } else {
                maxSpeed = speed - 1;
            }
        }
        return minSpeed;
    }
}
