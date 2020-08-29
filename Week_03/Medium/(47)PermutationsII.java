class Solution {
    private List<List<Integer>> result = new LinkedList();

    private void combine(int[] nums, LinkedList<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new LinkedList(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && used[i-1])) continue;
            current.add(nums[i]);
            used[i] = true;
            combine(nums, current, used);
            current.removeLast();
            used[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        combine(nums, new LinkedList(), new boolean[nums.length]);
        return result;
    }
}