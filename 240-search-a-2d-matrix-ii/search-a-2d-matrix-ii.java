class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //  int rows = matrix.length;
        // int cols = matrix[0].length;

        // for(int i=0; i<rows; i++) {
        //     for(int j=0; j<cols; j++) {
        //         if(matrix[i][j] == target){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            int current = matrix[row][col];

            // Case 1: found
            if (current == target) {
                return true;
            }

            // Case 2: current is too big → move left
            else if (current > target) {
                col--;
            }

            // Case 3: current is too small → move down
            else {
                row++;
            }
        }

        return false;
    }
}