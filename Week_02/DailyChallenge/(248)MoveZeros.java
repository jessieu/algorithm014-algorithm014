class Solution {
    public void moveZeroes(int[] nums) {
        for (int lastNonZero = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNonZero];
                nums[lastNonZero++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}

// snowball represents zero
//class Solution {
//    public void moveZeroes(int[] nums) {
//        int snowball = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) snowball++;
//            else if (snowball > 0) {
//                // replace
//                nums[i - snowball] = nums[i];
//                nums[i] = 0;
//            }
//        }
//    }
//}