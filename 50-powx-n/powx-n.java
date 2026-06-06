class Solution {
    public double myPow(double x, int n) {
         long power = n; // use long to handle Integer.MIN_VALUE
        
        // if power is negative
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1;

        while (power > 0) {
            // if odd power
            if (power % 2 == 1) {
                result *= x;
            }

            // square the base
            x *= x;

            // divide power by 2
            power /= 2;
        }

        return result;
    }
}