class Solution {
    public int findGCD(int[] nums) {

         // Assume first element is both minimum and maximum
        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum element
        for (int num : nums) {

            if (num < min)
                min = num;

            if (num > max)
                max = num;
        }

        // Return GCD of minimum and maximum
        return gcd(min, max);
    }

    // Euclidean Algorithm
    public int gcd(int a, int b) {

        // Base Case
        if (b == 0)
            return a;

        // Recursive Call
        return gcd(b, a % b);
        
    }
}