class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum1 = 0, sum2 = 0;
        int count1 = 0, count2 = 0;
        
        // Process the first half of the string
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                count1++;
            } else {
                sum1 += num.charAt(i) - '0';
            }
        }
        
        // Process the second half of the string
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') { count2++;
            } else {
                sum2 += num.charAt(i) - '0';
            }
        }
        
        // If the total number of '?' is odd, Alice always wins
        if ((count1 + count2) % 2 != 0) {
            return true;
        }
        
        // Check if Bob can equalize the sums
        return sum1 - sum2 != 9 * (count2 - count1) / 2;
    }
}