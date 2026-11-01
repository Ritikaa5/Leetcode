class Solution {
    public int maxSubArray(int[] nums) {

        // Store the maximum sum of a subarray ending at the current index
        int best_ending = nums[0];

        // Store the maximum subarray sum found so far
        int ans = nums[0];

        // Start traversing from the second element
        for (int i = 1; i < nums.length; i++) {

            // Option 1: Add current element to the previous subarray
            int v1 = best_ending + nums[i];

            // Option 2: Start a new subarray from the current element
            int v2 = nums[i];

            // Choose whichever gives the maximum sum
            best_ending = Math.max(v1, v2);

            // Update the overall maximum sum
            ans = Math.max(ans, best_ending);
        }

        // Return the maximum subarray sum
        return ans;
    }
}