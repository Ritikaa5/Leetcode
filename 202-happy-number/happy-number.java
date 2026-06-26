class Solution {
    public boolean isHappy(int n) {
  // HashSet visited numbers ko store karega
        HashSet<Integer> set = new HashSet<>();

        // Jab tak number 1 nahi ban jata
        // Aur koi number repeat nahi hota
        while (n != 1 && !set.contains(n)) {

            // Current number ko HashSet me store karo
            set.add(n);

            int sum = 0;

            // Digits ka square nikalne ke liye
            while (n > 0) {

                // Last digit nikalo
                int digit = n % 10;

                // Square add karo
                sum += digit * digit;

                // Last digit remove karo
                n = n / 10;
            }

            // Naya number ban gaya
            n = sum;
        }

        // Agar 1 mil gaya to Happy Number
        return n == 1;
    }
}