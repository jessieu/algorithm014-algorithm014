class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);

            if (min >= nums[mid] && min <= nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
        return min;
    }
}