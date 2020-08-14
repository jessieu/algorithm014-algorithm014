class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Overwrite nums1 from the end
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n -1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // copy the rest of nums2 to nums1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}

//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        // extra space; run two array in parallel;sorting with copy
//        int[] sorted = new int[nums1.length];
//
//        int i = 0, j = 0, k = 0;
//        while (k < nums1.length) {
//            if (i == m) {
//                sorted[k++] = nums2[j++];
//            } else if (j == n) {
//                sorted[k++] = nums1[i++];
//            } else {
//                sorted[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
//            }
//        }
//
//        for (i = 0; i < nums1.length; i++) {
//            nums1[i] = sorted[i];
//        }
//
//    }
//}