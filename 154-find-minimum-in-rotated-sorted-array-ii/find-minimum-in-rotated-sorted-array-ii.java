class Solution {
    public int findMin(int[] nums) {

        // Starting index of the array
        int left = 0;

        // Ending index of the array
        int right = nums.length - 1;

        // Continue until left and right point to the same index
        while (left < right) {

            // Find the middle index
            int mid = left + (right - left) / 2;

            // If mid element is smaller than right element,
            // minimum is at mid or somewhere on its left
            if (nums[mid] < nums[right]) {
                right = mid;
            }

            // If mid element is greater than right element,
            // minimum must be on the right side of mid
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // If both elements are equal, we cannot determine
            // which side contains the minimum, so reduce right
            else {
                right--;
            }
        }

        // Left and right meet at the minimum element
        return nums[left];
    }
}