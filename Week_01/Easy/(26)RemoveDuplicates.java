class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            // check whether element pointed by slow is the same as element pointer by fast
            if (nums[slow] != nums[fast]) {
                // replace slow's next element with fast
                nums[++slow] = nums[fast];

            }
            fast++;
        }

        return slow + 1;
    }
}