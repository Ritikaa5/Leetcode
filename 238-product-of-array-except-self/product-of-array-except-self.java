class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: answer[i] = product of all elements to the left of i
        int left = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = left;
            left *= nums[i];
        }

        // Pass 2: multiply in the product of all elements to the right of i
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }
}