class Solution {
    private Deque<Integer> deque = new LinkedList<>();
    private int[] nums;

    private void removeUseless(int i, int k) {
        // Remove the elements which are out of this window
        while ((!deque.isEmpty()) && deque.peek() <= i - k)
            deque.removeFirst();
        // For every element, the previous smaller elements are useless so
        // remove them from deque
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
            deque.removeLast(); // Remove from rear
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        this.nums = nums;

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; i++) {
            removeUseless(i, k);
            deque.addLast(i);
        }

        int index = 0;
        // Process rest of the elements, i.e., from nums[k] to nums[n-1]
        for (; i < nums.length; i++) {
            // The element at the front of the queue is the largest element of
            // previous window
            result[index++] = nums[deque.peek()];
            removeUseless(i, k);
            deque.addLast(i);
        }
        // add maximum in the last window to result
        result[index] = nums[deque.peek()];
        return result;
    }
}

/**
 * Brute Force
 */
//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//
//        int index = 0;
//        for (int i = 0; i < result.length; i++) {
//            int currentMax = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                currentMax = Math.max(currentMax, nums[j]);
//            }
//            result[index++] = currentMax;
//        }
//        return result;
//    }
//}