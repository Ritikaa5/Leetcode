class Solution {
    public double findMaxAverage(int[] nums, int k) {

          // Stores the sum of the current window
        int window_Sum = 0;

        // -------------------------------
        // Step 1: Calculate first window sum
        // -------------------------------
        for(int i = 0; i < k; i++) {
            window_Sum += nums[i];
        }

        // Initially, first window sum is the maximum sum
        int maxSum = window_Sum;

        
        // Step 2: Slide the window
       
        for(int i = k; i < nums.length; i++) {

            /*
             Remove the element leaving the window
             Add the new element entering the window

             Formula:
             New Window Sum =
             Old Window Sum
             - Outgoing Element
             + Incoming Element
            */
            window_Sum = window_Sum
                       - nums[i - k]
                       + nums[i];

            // Update maximum window sum found so far
            maxSum = Math.max(maxSum, window_Sum);
        }

        // Convert to double to get decimal average
        return (double) maxSum / k;
    }
}