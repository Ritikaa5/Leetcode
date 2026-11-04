

class Solution {

    class MultiSet {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            size++;
            sum += num;
        }

        void remove(int num) {
            int count = map.get(num);

            if (count == 1) map.remove(num);
            else map.put(num, count - 1);

            size--;
            sum -= num;
        }

        int getMax() {
            return map.lastKey();
        }

        int getMin() {
            return map.firstKey();
        }

        boolean contains(int num) {
            return map.containsKey(num);
        }
    }

    MultiSet lower, upper;

    void balance() {
        while (lower.size > upper.size + 1) {
            int val = lower.getMax();
            lower.remove(val);
            upper.add(val);
        }

        while (lower.size < upper.size) {
            int val = upper.getMin();
            upper.remove(val);
            lower.add(val);
        }
    }

    void insert(int num) {
        if (lower.size == 0 || num <= lower.getMax()) {
            lower.add(num);
        } else {
            upper.add(num);
        }
        balance();
    }

    void erase(int num) {
        if (lower.contains(num)) {
            lower.remove(num);
        } else {
            upper.remove(num);
        }
        balance();
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        lower = new MultiSet();
        upper = new MultiSet();

        long[] cost = new long[n - x + 1];

        // Calculate cost of every window
        for (int i = 0; i < n; i++) {

            insert(nums[i]);

            if (i >= x) {
                erase(nums[i - x]);
            }

            if (i >= x - 1) {

                int median = lower.getMax();

                long left =
                    (long) median * lower.size - lower.sum;

                long right =
                    upper.sum - (long) median * upper.size;

                cost[i - x + 1] = left + right;
            }
        }

        // DP
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Select a window of size x
                if (j > 0 && i >= x) {

                    if (dp[i - x][j - 1] != INF) {

                        dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i - x][j - 1] + cost[i - x]
                        );
                    }
                }
            }
        }

        return dp[n][k];
    }
}
