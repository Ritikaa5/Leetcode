class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         // List to store answer
        List<Integer> ans = new ArrayList<>();

        // Total rows
        int rows = matrix.length;

        // Total columns
        int cols = matrix[0].length;

        // Four boundaries
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        // Run until all boundaries cross each other
        while (top <= bottom && left <= right) {

           
            // 1. Print Top Row
            // left -----> right
       
            for (int j = left; j <= right; j++) {

                ans.add(matrix[top][j]);

            }

            // Top row is completed
            top++;

           
            // 2. Print Right Column
            // top -----> bottom
         
            for (int i = top; i <= bottom; i++) {

                ans.add(matrix[i][right]);

            }

            // Right column is completed
            right--;

           
            // 3. Print Bottom Row
            // right -----> left
            // Execute only if row exists
          
            if (top <= bottom) {

                for (int j = right; j >= left; j--) {

                    ans.add(matrix[bottom][j]);

                }

                // Bottom row completed
                bottom--;
            }

        
            // 4. Print Left Column
            // bottom -----> top
            // Execute only if column exists
           
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {

                    ans.add(matrix[i][left]);

                }

                // Left column completed
                left++;
            }

        }

        return ans;
    }
}