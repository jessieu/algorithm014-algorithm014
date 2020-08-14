class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        int count = 0;
        int moveTo = -1;
        // if current position is the right position, no swapping, go to next element
        for (int current = 0; count < len; current++) {
            int prev = current;
            while(current != moveTo) {
                // calculate position for movement
                moveTo = (prev + k) % len;

                // swap
                int temp = nums[moveTo];
                nums[moveTo] = nums[current];
                nums[current] = temp;

                // mark down next element's previous position
                prev = moveTo;

                count++;
            }
        }
    }
}

/**
 * A brilliant solution
 */

//class Solution {
//    private void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
//
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//
//        // reverse the whole array
//        reverse(nums, 0, nums.length - 1);
//
//        // reverse first k elements
//        reverse(nums, 0, k - 1);
//        // reverse last n-k elements
//        reverse(nums, k, nums.length - 1);
//
//    }
//}