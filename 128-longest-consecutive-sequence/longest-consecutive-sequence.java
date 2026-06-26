class Solution {
    public int longestConsecutive(int[] nums) {

        // Agar array empty hai to answer 0 hoga
        if (nums.length == 0) {
            return 0;
        }

        // HashSet me saare elements store karo
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Maximum sequence length store karega
        int maxLength = 0;

        // Har element ko check karo
        for (int num : set) {

            // Agar num-1 present nahi hai,
            // to num ek sequence ka starting point hai
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Jab tak next consecutive element milta rahe
                while (set.contains(current + 1)) {

                    current++;
                    length++;
                }

                // Maximum length update karo
                maxLength = Math.max(maxLength, length);
            }
        }

        // Final answer
        return maxLength;
    }
}