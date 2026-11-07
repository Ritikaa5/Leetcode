

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;

        // free: {weight, index}
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) ->
            a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // busy: {freeTime, weight, index}  (long, kyunki t + dur 2*10^5 * 2*10^5 tak ja sakta hai)
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];
        long t = 0;

        for (int j = 0; j < m; j++) {
            t = Math.max(t, j);

            // jo servers is time tak free ho gaye unhe wapas lao
            while (!busy.isEmpty() && busy.peek()[0] <= t) {
                long[] s = busy.poll();
                free.offer(new int[]{(int) s[1], (int) s[2]});
            }

            // koi server free nahi: sabse jaldi free hone wale tak wait karo
            if (free.isEmpty()) {
                t = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= t) {
                    long[] s = busy.poll();
                    free.offer(new int[]{(int) s[1], (int) s[2]});
                }
            }

            int[] s = free.poll();
            ans[j] = s[1];
            busy.offer(new long[]{t + tasks[j], s[0], s[1]});
        }

        return ans;
    }
}