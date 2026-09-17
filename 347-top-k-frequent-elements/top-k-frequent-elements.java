class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Har number ki frequency count karo
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Buckets banao
        // Index = frequency
        // Example: bucket[3] me woh numbers honge
        // jo 3 baar aaye hain
        List<Integer>[] bucket = new List[nums.length + 1];

        // Step 3: Har number ko uski frequency wale bucket me daalo
        for (int num : map.keySet()) {

            int frequency = map.get(num);

            // Agar bucket bana nahi hai to banao
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            // Number ko uske frequency wale bucket me daalo
            bucket[frequency].add(num);
        }

        // Step 4: Answer ke liye array
        int[] result = new int[k];

        int index = 0;

        // Step 5: Sabse high frequency se start karo
        for (int frequency = bucket.length - 1;
             frequency >= 0 && index < k;
             frequency--) {

            // Agar bucket empty hai to next frequency par jao
            if (bucket[frequency] == null) {
                continue;
            }

            // Current bucket ke numbers answer me daalo
            for (int num : bucket[frequency]) {

                result[index] = num;
                index++;

                // K elements mil gaye
                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}