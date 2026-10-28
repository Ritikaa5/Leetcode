
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Array ko sort karo
        Arrays.sort(nums);

        int n = nums.length;

        // First element fix karo
        for (int i = 0; i < n - 3; i++) {

            // Duplicate first element skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second element fix karo
            for (int j = i + 1; j < n - 2; j++) {

                // Duplicate second element skip karo
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Two pointers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    // long use kiya taaki integer overflow na ho
                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                            nums[i], nums[j],
                            nums[left], nums[right]
                        ));

                        // Duplicate left values skip karo
                        while (left < right &&
                               nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Duplicate right values skip karo
                        while (left < right &&
                               nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
