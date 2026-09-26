import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // Knowledge ko HashMap mein store karenge
        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        // Final answer store karne ke liye
        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            // Agar '(' mila
            if (s.charAt(i) == '(') {

                // ')' ka index find karo
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                // Bracket ke andar ka key nikalo
                String key = s.substring(i + 1, j);

                // Key HashMap mein hai ya nahi
                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append("?");
                }

                // ')' ke baad chale jao
                i = j + 1;

            } else {

                // Normal character hai
                result.append(s.charAt(i));

                i++;
            }
        }

        return result.toString();
    }
}