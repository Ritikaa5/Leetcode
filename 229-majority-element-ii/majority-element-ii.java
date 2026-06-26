class Solution {
    public List<Integer> majorityElement(int[] nums) {
          // Har element ki frequency store karne ke liye HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Array ke har element ki frequency count karo
        for (int num : nums) {

            // Agar element pehli baar aaya hai to frequency = 1
            // Warna existing frequency me 1 add kar do
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Answer store karne ke liye List
        List<Integer> ans = new ArrayList<>();

        // Step 2: HashMap ki har key ko traverse karo
        for (int key : map.keySet()) {

            // Agar frequency n/3 se zyada hai
            // To answer list me add kar do
            if (map.get(key) > nums.length / 3) {
                ans.add(key);
            }
        }

        // Final answer return karo
        return ans;
    }
}