class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        
        int remaining = 0;
        int prevEnd = 0;
        
        for (int[] interval : intervals) {
            int currentEnd = interval[1];
            // If current end extends past the max end seen, it is not covered
            if (currentEnd > prevEnd) {
                remaining++;
                prevEnd = currentEnd;
            }
        }
        
        return remaining;
    }
}