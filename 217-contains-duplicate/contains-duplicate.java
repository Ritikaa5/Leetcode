class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Array traverse
        for (int num : nums) {

            // Agar already present hai
            if (map.containsKey(num)) {

                // Duplicate mil gaya
                return true;
            }

            // First time mila
            else {
                map.put(num, 1);
            }
        }

        // Koi duplicate nahi mila
        return false;
    }
}