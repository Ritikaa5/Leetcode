class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap:
        // Key   -> Array element
        // Value -> Us element ka latest index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Array ko traverse karo
        for (int i = 0; i < nums.length; i++) {

            // Agar current element pehle bhi aa chuka hai
            if (map.containsKey(nums[i])) {

                // Previous index nikalo
                int prevIndex = map.get(nums[i]);

                // Agar dono indices ka difference <= k hai
                if (i - prevIndex <= k) {
                    return true;
                }
            }

            // Current element ka latest index update karo
            map.put(nums[i], i);
        }

        // Koi valid duplicate nahi mila
        return false;
    }
}