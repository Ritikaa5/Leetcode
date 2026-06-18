class Solution {
    public void moveZeroes(int[] nums) {

          int n = nums.length;

        // New array
        int[] res = new int[n];

        // Position to place next non-zero element
        int j = 0;

        // Copy non-zero elements
        for(int i = 0; i < n; i++) {

            if(nums[i] != 0) {

                res[j] = nums[i];
                j++;
            }
        }

        // Copy result back to original array
        for(int i = 0; i < n; i++) {

            nums[i] = res[i];
        }
    }
}