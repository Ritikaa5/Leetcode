class Solution {
    public int myAtoi(String s) {

        int i = 0;   // Pointer to traverse the string      
        int n = s.length();  // Length of string

        // ---------------- STEP 1 ----------------
        // Ignore all leading white spaces
        // Example: "   -42"
        // Move pointer until non-space character appears
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If string becomes empty after removing spaces
        // Example: "     "
        // Return 0 because no valid number exists
        if (i == n) {
            return 0;
        }

        // ---------------- STEP 2 ----------------
        // Check sign (+ or -)

        int sign = 1; // Default positive

        // If negative sign found
        if (s.charAt(i) == '-') {
            sign = -1;
            i++; // Move pointer to next character
        }

        // If positive sign found
        else if (s.charAt(i) == '+') {
            i++; // Move pointer to next character
        }

        // ---------------- STEP 3 ----------------
        // Start building the number digit by digit
        long num = 0;

        // Continue only while character is a digit
        while (i < n && Character.isDigit(s.charAt(i))) {

            // Convert character digit into integer
            // Example:
            // '5' - '0' = 5
            // '8' - '0' = 8
            int digit = s.charAt(i) - '0';

            // Build number
            // Example:
            // num = 12
            // digit = 3
            // new num = 12 * 10 + 3 = 123
            num = num * 10 + digit;

            // ---------------- STEP 4 ----------------
            // Handle overflow condition

            // If number exceeds Integer.MAX_VALUE
            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            // If number goes below Integer.MIN_VALUE
            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            // Move to next character
            i++;
        }

        // ---------------- STEP 5 ----------------
        // Apply sign and return final integer

        return (int)(sign * num); 
    }
}