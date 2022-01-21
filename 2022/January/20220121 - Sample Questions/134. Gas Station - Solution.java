class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTank = 0;
        int currentLocation = 0;
        int extraFuelNeeded = 0;
        //Iterate through each stop
        for (int stop = 0; stop < gas.length; stop++) {
            //Determine how much gas would be left in the tank after this stop
            gasTank += gas[stop] - cost[stop];
            //If the tank is empty, update the current location and reset
            if (gasTank < 0) {
                currentLocation = stop+1;
                extraFuelNeeded += gasTank;
                gasTank = 0;
            }
        }
        extraFuelNeeded += gasTank;
        return extraFuelNeeded < 0 ? -1 : currentLocation;
    }
}