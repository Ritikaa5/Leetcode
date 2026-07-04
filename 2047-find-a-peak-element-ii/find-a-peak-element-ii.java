class Solution {
    public int[] findPeakGrid(int[][] mat) {
        // Total number of rows
        int rows = mat.length;

        // Total number of columns
        int cols = mat[0].length;

        // Binary Search on columns
        int low = 0;
        int high = cols - 1;

        while (low <= high) {

            // Find middle column
            int mid = low + (high - low) / 2;

            // Assume first row contains the maximum element
            int maxRow = 0;

            // Find the row having the maximum element
            // in the current middle column
            for (int i = 1; i < rows; i++) {

                if (mat[i][mid] > mat[maxRow][mid]) {

                    // Update maxRow if a larger element is found
                    maxRow = i;
                }
            }

            // Current element (largest element in middle column)
            int current = mat[maxRow][mid];

            // Value on left side
            // If no left column exists, consider it -1
            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;

            // Value on right side
            // If no right column exists, consider it -1
            int right = (mid < cols - 1) ? mat[maxRow][mid + 1] : -1;

            // Since current is already the largest in its column,
            // Up and Down are automatically smaller.
            // So we only need to compare Left and Right.
            if (current > left && current > right) {

                // Peak found
                return new int[]{maxRow, mid};
            }

            // If left neighbour is larger,
            // peak must exist in left half
            if (left > current) {

                high = mid - 1;
            }

            // Otherwise peak must exist in right half
            else {

                low = mid + 1;
            }
        }

        // This line will never execute according to the problem constraints
        return new int[]{-1, -1};
    }
}