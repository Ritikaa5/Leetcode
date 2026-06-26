class Solution {
    public int majorityElement(int[] nums) {
       // Har element ki frequency store karne ke liye HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Array ke har element ko traverse karo
        for (int num : nums) {

            // Current element ki frequency 1 se increase karo
            // Agar element pehli baar aaya hai to frequency 1 hogi
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Agar kisi element ki frequency array ke half se zyada ho jaye
            // To wahi majority element hai
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        // Problem guarantee karti hai ki majority element hamesha hoga
        // Ye line sirf syntax complete karne ke liye hai
        return -1;
    }
}