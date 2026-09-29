class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int len = m + n - 1;
        if ((len & 1) == 1) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        int maxBal = len / 2;
        boolean[][][] dp = new boolean[m][n][maxBal + 2];

        dp[0][0][1] = true; // first cell must be '('

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int delta = grid[i][j] == '(' ? 1 : -1;
                for (int b = 0; b <= maxBal; b++) {
                    boolean reachable = false;
                    if (i > 0 && dp[i - 1][j][b]) reachable = true;
                    if (j > 0 && dp[i][j - 1][b]) reachable = true;
                    if (reachable) {
                        int nb = b + delta;
                        if (nb >= 0 && nb <= maxBal) {
                            dp[i][j][nb] = true;
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}