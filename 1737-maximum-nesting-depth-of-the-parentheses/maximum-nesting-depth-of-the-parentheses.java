class Solution {
    public int maxDepth(String s) {
        int count = 0;      // current depth
        int maxDepth = 0;   // maximum depth

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // opening bracket
            if(ch == '(') {
                count++;

                // update maximum depth
                maxDepth = Math.max(maxDepth, count);
            }

            // closing bracket
            else if(ch == ')') {
                count--;
            }
        }

        return maxDepth;
    }
}