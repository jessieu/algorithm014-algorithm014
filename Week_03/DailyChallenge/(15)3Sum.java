class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int complement = 0 - nums[i];
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum < complement) {
                    lo++;
                } else if (sum > complement) {
                    hi--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[lo++], nums[hi--]);
                    set.add(temp);
                }
            }
        }
        return new LinkedList<>(set);
    }
}