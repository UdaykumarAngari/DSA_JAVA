class Solution {
   public int nge(int[] nums2, int x, int p, int j) {
        for (int i = j + 1; i < p; i++) {
            if (nums2[i] > x) return nums2[i];
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int p = nums2.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int indexInNums2 = -1;
            for (int j = 0; j < p; j++) {
                if (nums2[j] == nums1[i]) {
                    indexInNums2 = j;
                    break;
                }
            }
            res[i] = nge(nums2, nums1[i], p, indexInNums2);
        }
        return res;
    }
}