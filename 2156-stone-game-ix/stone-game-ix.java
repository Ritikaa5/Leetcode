class Solution {
    public boolean stoneGameIX(int[] stones) {
                // Count frequencies of remainders when stones are divided by 3
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // Case 1: The number of stones with remainder 0 is EVEN
        if (count[0] % 2 == 0) {
            // Alice needs at least one stone of type 1 and one stone of type 2 to shift pairs safely.
            return count[1] > 0 && count[2] > 0;
        }

        // Case 2: The number of stones with remainder 0 is ODD
        // The absolute difference between remainder 1 and remainder 2 stones must be greater than 2.
        return Math.abs(count[1] - count[2]) > 2;

    }
}