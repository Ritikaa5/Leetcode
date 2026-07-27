class Solution {
    public int findContentChildren(int[] g, int[] s) {

         // Sort the greed array (children)
        Arrays.sort(g);

        // Sort the cookie sizes
        Arrays.sort(s);

         // i -> child pointer
        int i = 0;

        // j -> cookie pointer
        int j = 0;

        // Traverse until either all children or all cookies are processed
        while (i < g.length && j < s.length) {

            // If current cookie can satisfy current child
            if (s[j] >= g[i]) {

                // Child is satisfied, move to next child
                i++;

                // Current cookie is used, move to next cookie
                j++;
            } 
            else {
                // Cookie is too small, try the next larger cookie
                j++;
            }
        }

        // 'i' represents the number of satisfied children
        return i;
    }
}