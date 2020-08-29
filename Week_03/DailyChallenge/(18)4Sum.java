class Solution {
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new LinkedList();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // narrow range and skip duplicate
            if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                hi--;
            } else if (sum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                lo++;
            } else {
                result.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
        return result;
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new LinkedList();
        if (start == nums.length ||
                nums[start] * k > target ||
                target > nums[nums.length - 1] * k) {
            return result;
        }
        if (k == 2) return twoSum(nums, target, start);
        // pinpoint one position and find k - 1 sum from nums
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                result.add(new LinkedList<>(Arrays.asList(nums[i])));
                result.get(result.size() - 1).addAll(set);
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
}

// backtracking - not accepted
// if current result size is 4 and sum == target, add result to the list
//class Solution {
//    List<List<Integer>> result = new LinkedList();
//    private void backtracking(int[] nums, int first, int target, LinkedList<Integer> current, int sum) {
//        if (current.size() == 4 && sum == target) {
//            result.add(new LinkedList(current));
//            return;
//        }
//        for (int i = first; i < nums.length; i++) {
//            if (i > first && nums[i] == nums[i-1]) continue;
//            current.add(nums[i]);
//            backtracking(nums, i + 1, target, current, sum + nums[i]);
//            current.removeLast();
//        }
//    }
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        backtracking(nums, 0, target, new LinkedList<Integer>(), 0);
//        return result;
//    }
//}