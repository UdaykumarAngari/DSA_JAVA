class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;

        // j: last index in nums2
        int j = n - 1;

        // k: last index in nums1 including extra 0s
        int k = m + n - 1;

        // Fill nums1 from the back
        while (i >= 0 && j >= 0) {
            // Place larger element from end of nums1 or nums2
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 has leftovers, copy them to nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        // Remaining nums1 elements are already in correct position
    }
}