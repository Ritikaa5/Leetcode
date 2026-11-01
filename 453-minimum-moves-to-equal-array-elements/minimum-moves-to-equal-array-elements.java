class Solution {
    public int minMoves(int[] nums) {

        // Assume the first element is the minimum
        int min = nums[0];

        // Variable to store the sum of all elements
        int sum = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Add current element to sum
            sum += nums[i];

            // Check if current element is smaller than min
            if (nums[i] < min) {

                // Update minimum element
                min = nums[i];
            }
        }

        // Minimum moves = Sum - (Array Length * Minimum Element)
        return sum - (nums.length * min);
    }
}