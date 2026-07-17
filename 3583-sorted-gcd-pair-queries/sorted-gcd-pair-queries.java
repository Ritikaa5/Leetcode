class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // Find the maximum value in nums
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        // Step 1: Count frequencies of each number
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: Count how many numbers are multiples of each divisor 'd'
        long[] countMultiples = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            long totalMultiples = 0;
            for (int multiple = d; multiple <= maxVal; multiple += d) {
                totalMultiples += freq[multiple];
            }
            countMultiples[d] = totalMultiples;
        }

        // Step 3: Use inclusion-exclusion (backward sieve) to find exact GCD counts
        long[] exactGcdPairs = new long[maxVal + 1];
        for (int d = maxVal; d >= 1; d--) {
            long totalPairs = (countMultiples[d] * (countMultiples[d] - 1)) / 2;
            for (int multiple = 2 * d; multiple <= maxVal; multiple += d) {
                totalPairs -= exactGcdPairs[multiple];
            }
            exactGcdPairs[d] = totalPairs;
        }

        // Step 4: Build a running total (prefix sum) of GCD counts
        // prefixSum[i] holds the total number of pairs with GCD <= i
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + exactGcdPairs[i];
        }

        // Step 5: Answer each query using binary search (equivalent to bisect_right)
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIndex = queries[i];
            
            // Binary search for the smallest GCD 'g' where prefixSum[g] > targetIndex
            int low = 1;
            int high = maxVal;
            int resultGcd = maxVal;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSum[mid] > targetIndex) {
                    resultGcd = mid;
                    high = mid - 1; // Try to find a smaller valid GCD
                } else {
                    low = mid + 1;
                }
            }
            answer[i] = resultGcd;
        }

        return answer;
    }
}