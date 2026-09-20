class Solution {
    public int reverseDegree(String s) {
       int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int reverseAlphaPos = 26 - (s.charAt(i) - 'a'); // 'a'->26, 'z'->1
            int stringPos = i + 1; // 1-indexed
            sum += reverseAlphaPos * stringPos;
        }
        return sum; 
    }
}