class Solution {
    public int diagonalSum(int[][] mat) {
         // Size of square matrix
        int n = mat.length;

        // Variable to store final answer
        int sum = 0;

        // Traverse every row
        for (int i = 0; i < n; i++) {

            // Add Main Diagonal Element
            // Formula : (i, i)
            sum += mat[i][i];

            // Add Secondary Diagonal Element
            // Formula : (i, n-1-i)
            sum += mat[i][n - 1 - i];
        }

        // If matrix size is odd (3x3, 5x5, 7x7...)
        if (n % 2 == 1) {

            // Center element gets counted twice
            // Remove it once
            sum -= mat[n / 2][n / 2];
        }

        // Return final answer
        return sum;
    }
}