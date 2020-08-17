class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // sort
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // two pointers: find the intersection
        int n = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] result = new int[n];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result[k++] = nums1[i++];
                j++;
            }
        }

        return Arrays.copyOfRange(result, 0, k);
    }
}

//class Solution {
//    public int[] intersect(int[] nums1, int[] nums2) {
//        // iterate the array with smaller size - assmue it's nums1
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i : nums1) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//
//        int index = 0;
//        for (int i : nums2) {
//            int frequency = map.getOrDefault(i, 0);
//            if (frequency > 0) {
//                // overwrite the original array might not be a good idea
//                // but it can save space and time complexity
//                nums1[index++] = i;
//                map.put(i, frequency - 1);
//            }
//        }
//
//        return Arrays.copyOfRange(nums1, 0, index);
//    }
//}