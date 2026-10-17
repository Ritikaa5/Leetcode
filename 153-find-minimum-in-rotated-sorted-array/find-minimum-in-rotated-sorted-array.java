class Solution {
    public int findMin(int[] nums) {

          int left = 0;
        int right = nums.length - 1;

        // Keep shrinking search space
        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum is in right half
            if (nums[mid] > nums[right]) {

                left = mid + 1;
            }

            // Minimum is at mid or left half
            else {

                right = mid;
            }
        }

        // left == right points to minimum element
        return nums[left];
        
    }
}