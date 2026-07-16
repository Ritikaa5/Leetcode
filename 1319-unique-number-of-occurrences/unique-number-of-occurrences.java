class Solution {
    public boolean uniqueOccurrences(int[] arr) {

         // Create HashMap to store frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Create HashSet to store frequencies
        HashSet<Integer> set = new HashSet<>();

        // Traverse all frequencies
        for (int freq : map.values()) {

            // If frequency already exists, return false
            if (set.contains(freq)) {
                return false;
            }

            // Otherwise add frequency to the set
            set.add(freq);
        }

        // All frequencies are unique
        return true;

        
    }
}