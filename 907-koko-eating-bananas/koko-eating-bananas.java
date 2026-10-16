class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // right = sabse badi pile
        for (int p : piles) {
            right = Math.max(right, p);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid;        // mid chal gaya, aur chhota try karo
            } else {
                left = mid + 1;     // mid slow hai, tez speed chahiye
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        long hours = 0;  // overflow se bachne ke liye long

        for (int p : piles) {
            hours += (p + k - 1) / k;   // ceil(p / k) ka integer trick
        }

        return hours <= h;
    }
}