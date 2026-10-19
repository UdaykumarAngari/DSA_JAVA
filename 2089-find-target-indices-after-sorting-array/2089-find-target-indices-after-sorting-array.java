class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0, count = 0;

        for (int num : nums) {
            if (num < target) smaller++;
            else if (num == target) count++;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = smaller; i < smaller + count; i++) {
            res.add(i);
        }

        return res;
    }
}