class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Step 1: Build the directed adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] inv : invocations) {
            graph[inv[0]].add(inv[1]);
        }

        // Step 2: Use BFS to find all suspicious methods
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph[curr]) {
                if (!suspicious[neighbor]) {
                     suspicious[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Check if any non-suspicious method invokes a suspicious method
        for (int[] inv : invocations) {
            int u = inv[0];
            int v = inv[1];
            if (!suspicious[u] && suspicious[v]) {
                // Isolation condition violated: Return all methods
                List<Integer> allMethods = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    allMethods.add(i);
                }
                return allMethods;

                     }
        }

        // Step 4: Condition satisfied: Return only non-suspicious methods
        List<Integer> remainingMethods = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                remainingMethods.add(i);
            }
        }
        return remainingMethods;
    }
}