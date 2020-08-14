class Solution {
    public void moveZeroes(int[] nums) {
        int zeroFinder = 0;
        int nonZeroFinder = 1;

        while (nonZeroFinder < nums.length && zeroFinder < nums.length) {
            if (nums[zeroFinder] != 0) {
                zeroFinder++;
            } else if (nums[nonZeroFinder] == 0 || nonZeroFinder < zeroFinder) {
                nonZeroFinder++;
            } else {
                // replace
                nums[zeroFinder++] = nums[nonZeroFinder];
                nums[nonZeroFinder++] = 0;
            }
        }
    }
}