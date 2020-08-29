class Solution {
    private List<List<Integer>> result = new LinkedList();

    private void combine(int[] nums, LinkedList<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new LinkedList(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            combine(nums, current);
            current.removeLast();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        combine(nums, new LinkedList<>());
        return result;
    }

}