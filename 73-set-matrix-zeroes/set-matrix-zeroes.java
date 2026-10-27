class Solution {
    public void setZeroes(int[][] matrix) {

        // Matrix mein total rows aur columns
        int m = matrix.length;
        int n = matrix[0].length;

        // Check karo ki first row mein pehle se koi zero hai ya nahi
        boolean firstRowZero = false;

        // Check karo ki first column mein pehle se koi zero hai ya nahi
        boolean firstColZero = false;

        // First row ko check karo
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // First column ko check karo
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        // Baaki matrix mein zero dhoondo
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // Agar current element zero hai
                if (matrix[i][j] == 0) {

                    // Us row ke first cell ko marker banao
                    matrix[i][0] = 0;

                    // Us column ke first cell ko marker banao
                    matrix[0][j] = 0;
                }
            }
        }

        // Markers ke basis par rows aur columns zero karo
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // Row ya column marker zero hai toh current cell zero karo
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Agar first row mein pehle zero tha toh poori first row zero karo
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Agar first column mein pehle zero tha toh poora first column zero karo
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}