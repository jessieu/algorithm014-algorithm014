class Solution {
    //[[1]]
    //[[2,1], [1,2]]
    //[[3,2,1], [2,3,1], [2,1,3], [3,1,2], [1,3,2], [1,2,3]]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        if (nums.length == 0) return result;
        List<Integer> current = new LinkedList();
        current.add(nums[0]);
        result.add(new LinkedList(current));
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new LinkedList();
            for (int j = 0; j <= i; j++) {
                // insert current element to list of result
                for (List<Integer> list : result) {
                    List<Integer> newList = new LinkedList(list);
                    newList.add(j, nums[i]);
                    temp.add(newList);
                }
            }
            result = temp;
        }
        return result;
    }
}

/**
 * Backtracking
 */
//class Solution {
//    private List<List<Integer>> result = new LinkedList();
//
//    public List<List<Integer>> permute(int[] nums) {
//        combine(nums, new LinkedList<>());
//        return result;
//    }
//
//    private void combine(int[] nums, LinkedList<Integer> current) {
//        if (current.size() == nums.length) {
//            result.add(new LinkedList(current));
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (current.contains(nums[i])) continue;
//            current.add(nums[i]);
//            combine(nums, current);
//            current.removeLast();
//        }
//
//    }
//}