class Solution {

    private int[][] memo;
    private int[] prefixSums;

    public int stoneGameV(int[] stoneValue) {
                int n = stoneValue.length;
        memo = new int[n][n];
        prefixSums = new int[n + 1];
        
        // Build prefix sums to calculate subarray sums in O(1) time
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + stoneValue[i];
        }
        
        return getMaxScore(stoneValue, 0, n - 1);
    }
       private int getMaxScore(int[] stoneValue, int left, int right) {
        // Base case: Only one stone remains, no more splits possible
        if (left >= right) {
            return 0;
        }
        
        // Return cached result if already calculated
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        
        int maxScore = 0;
        
        // Iterate through all possible split points 'i' between left and right
        for (int i = left; i < right; i++) {
            // Calculate sum of left section [left, i] and right section [i + 1, right]
            int leftSum = prefixSums[i + 1] - prefixSums[left];
            int rightSum = prefixSums[right + 1] - prefixSums[i + 1];
            if (leftSum < rightSum) {
                // Bob throws away the right row. Alice keeps left row score + continues on left
                maxScore = Math.max(maxScore, leftSum + getMaxScore(stoneValue, left, i));
            } else if (leftSum > rightSum) {
                // Bob throws away the left row. Alice keeps right row score + continues on right
                maxScore = Math.max(maxScore, rightSum + getMaxScore(stoneValue, i + 1, right));
            } else {
                // Sums are equal; Alice chooses which row to throw away to maximize score
                int chooseLeft = leftSum + getMaxScore(stoneValue, left, i);
                int chooseRight = rightSum + getMaxScore(stoneValue, i + 1, right);
                maxScore = Math.max(maxScore, Math.max(chooseLeft, chooseRight));
            }
        }
        
        return memo[left][right] = maxScore;
    }
}