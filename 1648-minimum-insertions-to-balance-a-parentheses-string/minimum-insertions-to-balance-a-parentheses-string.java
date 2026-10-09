class Solution {
    public int minInsertions(String s) {
Stack<Character> stack = new Stack<>();
        int res = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                // current char is ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;            // pair "))" mil gaya, dusra ')' skip
                } else {
                    res++;          // ek ')' insert karna padega
                }

                if (!stack.isEmpty()) {
                    stack.pop();    // pehle wale '(' se match
                } else {
                    res++;          // '(' insert karna padega
                }
            }
            i++;
        }

        // bache hue har '(' ko 2 ')' chahiye
        return res + stack.size() * 2;
    }
}