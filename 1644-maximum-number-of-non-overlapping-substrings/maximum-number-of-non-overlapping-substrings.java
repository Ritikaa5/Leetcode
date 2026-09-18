

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] != i) {
                continue;
            }

            int end = last[c];
            boolean valid = true;
            int j = i;

            while (j <= end) {
                int idx = s.charAt(j) - 'a';

                if (first[idx] < i) {
                    valid = false;
                    break;
                }

                if (last[idx] > end) {
                    end = last[idx];
                }

                j++;
            }

            if (valid) {
                intervals.add(new int[]{i, end});
            }
        }

        intervals.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

        List<String> result = new ArrayList<>();
        int lastEnd = -1;

        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                lastEnd = interval[1];
            }
        }

        return result;
    }
}