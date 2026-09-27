class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // s1 ki length
        int len = s1.length();

        // s1 ko character array mein convert karo
        char[] target = s1.toCharArray();

        // s1 ke characters ko sort karo
        Arrays.sort(target);

        // s2 mein len size ki window check karo
        for (int i = 0; i <= s2.length() - len; i++) {

            // s2 se len characters nikalo
            String window = s2.substring(i, i + len);

            // current window ko character array mein convert karo
            char[] current = window.toCharArray();

            // current window ko sort karo
            Arrays.sort(current);

            // dono same hain?
            if (Arrays.equals(target, current)) {
                return true;
            }
        }

        return false;
    }
}