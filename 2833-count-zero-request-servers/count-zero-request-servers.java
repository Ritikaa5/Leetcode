
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = logs.length;
        int q = queries.length;

        int[] ans = new int[q];
        int[] count = new int[n + 1];

        // Store original query indices
        Integer[] index = new Integer[q];

        for (int i = 0; i < q; i++) {
            index[i] = i;
        }

        // Sort logs according to time
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        // Sort queries according to time
        Arrays.sort(index, (a, b) -> queries[a] - queries[b]);

        int left = 0;
        int right = 0;
        int active = 0;

        for (int i = 0; i < q; i++) {

            int time = queries[index[i]];
            int start = time - x;

            // Add logs inside right boundary
            while (right < m && logs[right][1] <= time) {

                int id = logs[right][0];

                count[id]++;

                if (count[id] == 1) {
                    active++;
                }

                right++;
            }

            // Remove logs outside left boundary
            while (left < right && logs[left][1] < start) {

                int id = logs[left][0];

                count[id]--;

                if (count[id] == 0) {
                    active--;
                }

                left++;
            }

            // Servers without requests
            ans[index[i]] = n - active;
        }

        return ans;
    }
}
