class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = position.length;

        // Pair each car as {position, speed}
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position, closest to target first
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double leadTime = 0;

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            // If this car takes longer than the fleet ahead, it can't catch up
            if (time > leadTime) {
                fleets++;
                leadTime = time;
            }
        }

        return fleets;
    }
}