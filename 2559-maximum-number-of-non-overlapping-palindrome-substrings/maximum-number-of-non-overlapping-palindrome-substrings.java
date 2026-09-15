class Solution {
    public int maxPalindromes(String s, int k) {
       int n = s.length();
        char[] c = s.toCharArray();
        
        // isPal[i][j] = true if s[i..j] is palindrome (inclusive)
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) isPal[i][i] = true;
        for (int i = 0; i < n - 1; i++) isPal[i][i+1] = (c[i] == c[i+1]);
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                isPal[i][j] = (c[i] == c[j]) && isPal[i+1][j-1];
            }
        }
        
        // dp[i] = max number of valid substrings using s[0..i) (first i characters)
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // skip character at index i-1
            
            // Only need to check lengths k and k+1 due to the key insight:
            // any palindrome longer than k+1 can be shrunk from both ends
            // to a palindrome of length k or k+1 (parity preserved appropriately)
            for (int len = k; len <= k + 1; len++) {
                if (i - len >= 0) {
                    int start = i - len;
                    int end = i - 1;
                    if (isPal[start][end]) {
                        dp[i] = Math.max(dp[i], dp[start] + 1);
                    }
                }
            }
        }
        
        return dp[n];  
    }
}