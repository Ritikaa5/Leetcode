class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Pass 1: har row aur column me servers count karo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Pass 2: jis server ki row ya column me 1 se zyada server hain, usse count karo
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }
}