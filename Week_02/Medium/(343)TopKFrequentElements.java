class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // build hash map : map element to frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n : map.keySet()) {
            heap.add(n);
            // remove element greater than k
            if (heap.size() > k) heap.poll();
        }

        // build the output arrary
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }
}

// There's also a quick sort approach, but...I don't understand them