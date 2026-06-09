class Solution {
    public boolean rotateString(String s, String goal) {
        int s1 = s.length();
        int g1 = goal.length();

        if(s1 != g1) {
            return false;
        }
        String doubleString = s + s;  // this will become --> "abcdeabcde"

        // ab check kro agr double string mai given string milti hai to true hai
        // check if goal exists
        return doubleString.contains(goal);
    }
}