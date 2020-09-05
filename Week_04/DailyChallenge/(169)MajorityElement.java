// Boyer-Moore Voting Algorithm
// The length of majority elements can be written as k + n / 2,
// then there are t (t = n / 2 - k) elements different from
// the majority. This algorithm uses t of majority to cancel its enemies,
// those different numbers, and what survives must be the majority.
// Animation: https://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html

class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) majority = num;
            if (majority == num) count++;
            else count--;
        }
        return majority;
    }
}

// divide and conquer
// 1. two halves' majority agreed, then return
// 2. two halves' majority disagreed, compare their counts, return the greater one.
//class Solution {
//    private int frequency(int[] nums, int start, int end, int target) {
//        int count = 0;
//        for (int i = start; i <= end; i++) {
//            if (nums[i] == target) count++;
//        }
//        return count;
//    }
//    private int majority(int[] nums, int start, int end) {
//        // terminator
//        if (start== end) return nums[start];
//
//        int mid = start + (end - start) / 2;
//        int left = majority(nums, start, mid);
//        int right = majority(nums, mid+1, end);
//
//        // majority agree
//        if (left == right) return left;
//
//        // majority disagree
//        int leftCount = frequency(nums, start, mid, left);
//        int rightCount = frequency(nums, mid+1, end, right);
//
//        return leftCount > rightCount ? left : right;
//    }
//
//    public int majorityElement(int[] nums) {
//        return majority(nums, 0, nums.length - 1);
//    }
//}

// Time Complexity: O(N) visit every element once at worst, e.g., [4,4,4,5,5,5,4]
// Space Complexity: O(N) for using extra memory, the hash map
//class Solution {
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap();
//        int majority = nums.length / 2;
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//            if (map.get(num) > majority) return num;
//        }
//        return -1;
//    }
//}


