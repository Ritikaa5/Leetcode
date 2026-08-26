class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLen = n + 1;
        String result = "";
        
        int left = 0;
        int countOnes = 0;
        
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }
            
            // Shrink the window from the left as long as it contains exactly k ones
            while (countOnes == k) {
                // Ensure the window starts exactly at a '1' to minimize length
                if (s.charAt(left) == '1') {
                    int currentLen = right - left + 1;
                    String currentSub = s.substring(left, right + 1);
                    
                    if (currentLen < minLen) {
                        minLen = currentLen;
                        result = currentSub;
                    } else if (currentLen == minLen) {
   // Compare lexicographically if lengths match
                        if (currentSub.compareTo(result) < 0) {
                            result = currentSub;
                        }
                    }
                    
                    // Decouple the leftmost '1' to slide the window forward
                    countOnes--;
                }
                left++;
            }
        }
        
        return result;
    }
}