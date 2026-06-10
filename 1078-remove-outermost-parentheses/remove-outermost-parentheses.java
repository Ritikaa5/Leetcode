class Solution {
    public String removeOuterParentheses(String s) {
         // final answer store karne ke liye
        StringBuilder result = new StringBuilder();

        // current parentheses depth track karega
        // kitne brackets open hain
        int count = 0;

        // string ke har character par loop
        for(int i = 0; i < s.length(); i++) {

            // current character nikalo
            char ch = s.charAt(i);

            // agar opening bracket mila
            if(ch == '(') {

                // agar count > 0 hai
                // matlab ye outermost '(' nahi hai
                // isko result me add kar do
                if(count > 0) {
                    result.append(ch);
                }

                // opening bracket mila
                // depth increase karo
                count++;
            }

            // agar closing bracket mila
            else {

                // closing bracket hai
                // pehle depth decrease karo
                count--;

                // agar count > 0 hai
                // matlab ye outermost ')' nahi hai
                // isko result me add karo
                if(count > 0) {
                    result.append(ch);
                }
            }
        }

        // StringBuilder ko String me convert karke return
        return result.toString();
    }
}