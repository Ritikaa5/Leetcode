class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int count = 0;
        int sum = 0;

        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Check first window
        if (sum >= threshold * k) {
            count++;
        }
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {

            // Remove outgoing element
            sum -= arr[i - k];

            // Add incoming element
            sum += arr[i];

            // Check current window
            if (sum >= threshold * k) {
                count++;
            }
        }
        return count;
    }
}