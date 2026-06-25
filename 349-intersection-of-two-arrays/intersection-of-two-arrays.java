class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        
         // nums1 ke unique elements store karne ke liye
        HashSet<Integer> set1 = new HashSet<>();

        // nums1 ke saare elements set me daal do
        for (int num : nums1) {
            set1.add(num);
        }

        // Common elements store karne ke liye
        HashSet<Integer> ans = new HashSet<>();

        // nums2 traverse karo
        for (int num : nums2) {

            // Agar element nums1 me bhi present hai
            if (set1.contains(num)) {

                // Answer set me add kar do
                // HashSet duplicate automatically handle karega
                ans.add(num);
            }
        }

        // Final answer array banao
        int result[] = new int[ans.size()];

        int i = 0;

        // HashSet se elements array me copy karo
        for (int num : ans) {
            result[i] = num;
            i++;
        }

        // Final array return karo
        return result;
    }
}