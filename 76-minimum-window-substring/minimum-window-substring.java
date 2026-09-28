//import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        // t ke characters ki required frequency store karenge
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {

            char c = t.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Current window ke characters ki frequency
        HashMap<Character, Integer> window = new HashMap<>();

        // Window ke starting aur ending points
        int left = 0;
        int right = 0;

        // Kitne required characters abhi tak mil chuke hain
        int count = 0;

        // Minimum window ki length
        int minLength = Integer.MAX_VALUE;

        // Minimum window kaha se start ho rahi hai
        int start = 0;

        // Right pointer se window ko expand karenge
        while (right < s.length()) {

            // Right wale index ka character
            char c = s.charAt(right);

            // Current window mein character add karo
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Agar character required hai
            // aur required frequency se zyada nahi hua
            if (map.containsKey(c) &&
                window.get(c) <= map.get(c)) {

                count++;
            }

            // Right ko next index par le jao
            right++;

            // Agar window mein t ke saare characters aa gaye
            while (count == t.length()) {

                // Current window ki length
                int currentLength = right - left;

                // Agar current window sabse chhoti hai
                if (currentLength < minLength) {

                    minLength = currentLength;

                    // Minimum window ka starting index
                    start = left;
                }

                // Left wale character ko nikalo
                char leftChar = s.charAt(left);

                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                // Agar required character ki frequency
                // required amount se kam ho gayi
                if (map.containsKey(leftChar) &&
                    window.get(leftChar) < map.get(leftChar)) {

                    count--;
                }

                // Left ko next index par le jao
                left++;
            }
        }

        // Agar koi valid window nahi mili
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        // Minimum window return karo
        return s.substring(start, start + minLength);
    }
}