class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // nums1 ke elements ki frequency store karne ke liye HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // nums1 traverse karke frequency count karo
        for (int num : nums1) {

            // Agar num pehle se present hai to frequency +1
            // Nahi hai to default value 0 lekar +1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Common elements store karne ke liye
        ArrayList<Integer> list = new ArrayList<>();

        // nums2 traverse karo
        for (int num : nums2) {

            // Agar num ki frequency map me 0 se zyada hai
            // To iska matlab ye element nums1 me available hai
            if (map.getOrDefault(num, 0) > 0) {

                // Answer me add kar do
                list.add(num);

                // Ek occurrence use ho gayi
                // Isliye frequency 1 kam kar do
                map.put(num, map.get(num) - 1);
            }
        }

        // ArrayList ko int[] me convert karne ke liye array banao
        int ans[] = new int[list.size()];

        // List ke elements array me copy karo
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        // Final answer return karo
        return ans;
    }
}