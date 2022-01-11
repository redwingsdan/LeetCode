class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Sort to ensure we order by pickup destination
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        boolean canCarpool = true;
        List<Integer> peopleInCar = new ArrayList<>();
        //Go through each stop
        for (int stop = 0; stop < trips.length; stop++) {
            //get info from next stop
            int[] stopData = trips[stop];
            int newPassengers = stopData[0];
            int pickupLocation = stopData[1];
            int dropoffLocation = stopData[2];
            //let people out
            //If person has reached their stop then remove them from the car
            peopleInCar = peopleInCar.stream().filter(p -> p > pickupLocation).collect(Collectors.toList());
            //let people in
            if ((peopleInCar.size() + newPassengers) > capacity) {
                //Too many people in car
                return false;
            }
            //Add person to car as their dropoff location
            for (int i = 0; i < newPassengers; i++) {
                peopleInCar.add(dropoffLocation);
            }
        }
        return canCarpool;
    }
}