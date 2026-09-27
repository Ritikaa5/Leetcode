class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Normal character ya '('
            if (c != ')') {
                stack.push(c);
            }

            // ')' mila
            else {

                String temp = "";

                // '(' tak characters nikalo
                while (stack.peek() != '(') {
                    temp += stack.pop();
                }

                // '(' ko remove karo
                stack.pop();

                // Reversed string ko wapas stack me daalo
                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }
            }
        }

        // Final answer
        String ans = "";

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        // Stack se reverse mila hai,
        // isliye answer ko reverse karna padega
        String result = "";

        for (int i = ans.length() - 1; i >= 0; i--) {
            result += ans.charAt(i);
        }

        return result;
    }
}