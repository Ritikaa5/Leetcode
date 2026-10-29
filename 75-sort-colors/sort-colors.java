
class Solution {
    public void sortColors(int[] nums) {

        // 0s ko left, 2s ko right aur 1s ko middle mein rakhna hai
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            // Agar current element 0 hai
            if (nums[mid] == 0) {

                // nums[low] aur nums[mid] ko swap karo
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }

            // Agar current element 1 hai
            else if (nums[mid] == 1) {

                // 1 ko middle mein rehne do
                mid++;
            }

            // Agar current element 2 hai
            else {

                // nums[mid] aur nums[high] ko swap karo
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;

                // Yahan mid++ nahi karna,
                // kyunki naya element abhi check karna hai
            }
        }
    }
}
