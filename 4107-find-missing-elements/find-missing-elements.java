class Solution {
    public List<Integer> findMissingElements(int[] nums) {
      
     List<Integer> result = new ArrayList<>();
        Set<Integer> presentNumbers = new HashSet<>();
        
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        
        // Find boundaries and record present elements
        for (int num : nums) {
            presentNumbers.add(num);
            if (num < minVal) {
                minVal = num;
            }
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        // Iterate through the strict range [minVal, maxVal] 
        // to find elements not present in the lookup set
        for (int i = minVal; i <= maxVal; i++) {
            if (!presentNumbers.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}