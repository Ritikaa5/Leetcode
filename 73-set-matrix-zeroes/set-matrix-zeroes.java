class Solution {
    public void setZeroes(int[][] matrix) {

         
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Arrays to mark which rows and columns should become zero
        int[] row = new int[rows];
        int[] col = new int[cols];

        // Step 1: Mark rows and columns containing original zeroes
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    row[i] = 1;
                    col[j] = 1;

                }
            }
        }

        // Step 2: Convert marked rows and columns to zero
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (row[i] == 1 || col[j] == 1) {

                    matrix[i][j] = 0;

                }
            }
        }
    }
}