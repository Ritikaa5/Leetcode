class Solution {
    public int searchInsert(int[] nums, int target) {
        // Search space ki starting aur ending index
        int low = 0;
        int high = nums.length - 1;

        // Jab tak valid search space hai
        while (low <= high) {

            // Middle index nikal rahe hain
            // Ye overflow-safe way hai
            int mid = low + (high - low) / 2;

            // Agar target mil gaya
            if (nums[mid] == target) {
                return mid; // uska index return kar do
            }

            // Agar target right side mein hoga
            if (nums[mid] < target) {

                // Left part ko ignore kar do
                low = mid + 1;
            }

            // Agar target left side mein hoga
            else {

                // Right part ko ignore kar do
                high = mid - 1;
            }
        }

        /*
         * Agar target array mein nahi mila
         *
         * Loop khatam hone par:
         * low us position par khada hota hai
         * jahan target insert hona chahiye
         */
        return low;
    }
}