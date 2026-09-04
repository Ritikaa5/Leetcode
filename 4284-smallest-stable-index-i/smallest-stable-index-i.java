class Solution {
    public int firstStableIndex(int[] nums, int k) {
                int n = nums.length;
        
        // Precompute prefix maximums
        int[] leftMax = new int[n];
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currMax = Math.max(currMax, nums[i]);
            leftMax[i] = currMax;
        }
        
        // Precompute suffix minimums
        int[] rightMin = new int[n];
        int currMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            currMin = Math.min(currMin, nums[i]);
            rightMin[i] = currMin;
        }
        
        // Find the smallest stable index
        for (int i = 0; i < n; i++) {
            if (leftMax[i] - rightMin[i] <= k) {
                return i;
            }
        }
        
        return -1;

    }
}