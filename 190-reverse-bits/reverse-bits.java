class Solution {
    public int reverseBits(int n) {
        int result = 0;

        // Process all 32 bits
        for (int i = 0; i < 32; i++) {

            // Get the last bit of n
            int bit = n & 1;

            // Shift result to the left to make space
            result = result << 1;

            // Add the extracted bit
            result = result | bit;

            // Remove the last bit from n
            n = n >>> 1;   // Unsigned right shift
        }

        return result;
    }
}