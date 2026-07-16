class Solution {
    public void rotate(int[] nums, int k) {

     int n = nums.length;

        // Handle cases where k > n
        k = k % n;

        // Temporary array
        int temp[] = new int[n];

        // Store elements at their new positions
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];  // left mai temp[i] = nums[(i+k)%n]
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];          
        }
        
    }
}