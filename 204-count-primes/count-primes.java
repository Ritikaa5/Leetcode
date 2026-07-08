class Solution {
    public int countPrimes(int n) {

       
         
        // int count = 0;

        // // Check every number from 2 to n-1
        // for (int i = 2; i < n; i++) {

        //     boolean isPrime = true;

        //     // Check if i is divisible by any number
        //     for (int j = 2; j <= Math.sqrt(i); j++) {

        //         if (i % j == 0) {
        //             isPrime = false;
        //             break;
        //         }
        //     }

        //     // If prime, increase count
        //     if (isPrime) {
        //         count++;
        //     }
        // }

        // return count;



          if (n <= 2) {
            return 0;
        }

        boolean[] prime = new boolean[n];

        // Sabko initially prime maan lo
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        // Multiples ko non-prime mark karo
        for (int i = 2; i * i < n; i++) {

            if (prime[i]) {

                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }

        return count;
    }
}