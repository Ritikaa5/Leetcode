class Solution {
    public int stoneGameVIII(int[] stones) {
         int n = stones.length;
        
        // prefix[i] = sum(stones[0..i])
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }
        
        // dp represents dp[i], computed from right to left, using O(1) extra space
        int dp = prefix[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, prefix[i] - dp);
        }
        
        return dp;
    }
}