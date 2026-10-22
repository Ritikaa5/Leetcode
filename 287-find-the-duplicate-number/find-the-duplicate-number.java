class Solution {
    public int findDuplicate(int[] nums) {

        // for(int i = 0; i < nums.length; i++) {

        //     for(int j = i + 1; j < nums.length; j++) {

        //         if(nums[i] == nums[j]) {
        //             return nums[i];
        //         }
        //     }
        // }

        //  return -1;   // ----> T: O(n2)

       
        // HashSet<Integer> set = new HashSet<>();
        // for(int i = 0; i < nums.length; i++) {
        //     // If already present
        //     if(set.contains(nums[i])) {
        //         return nums[i];
        //     }
        //     set.add(nums[i]);
        // }
        // return -1;

    //     int ans = 0;
    //    for(int i=0; i<nums.length; i++){
    //     // sabki absolute value as index dekhege/ lege
    //     int index = Math.abs(nums[i]);
    //     // agar woh phle se negative hai to ans mai store krwa lege 
    //     if(nums[index] < 0) {
    //         ans = Math.abs(nums[i]);
    //     }
    //     // agar nhi hai to negative bnayge 
    //     nums[index] = -nums[index];
    //    }
    //   return ans;
      

      Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }

}