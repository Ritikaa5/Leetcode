class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        
        int validCount = 0;
        
        // Loop through all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            if (canForm(num, count)) {
                validCount++;
            }
        }
        
        return validCount;
    }
    
    private boolean canForm(int num, int[] available) {
        int[] req = new int[10];
        int temp = num;
        while (temp > 0) {
            req[temp % 10]++;
            temp /= 10;
        }
        
        for (int i = 0; i < 10; i++) {
            if (req[i] > available[i]) {
                return false;
            }
        }
        
        return true;
    }
}