class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) return 0;

        // dp[j] represents number of ways to form t[0..j) using s[0..i)
        long[] dp = new long[n + 1];
        dp[0] = 1; // empty t is always matched exactly once

        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            // iterate j backwards so dp[j-1] still holds the previous row's value
            for (int j = Math.min(i, n); j >= 1; j--) {
                if (sc == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return (int) dp[n];
    }
}