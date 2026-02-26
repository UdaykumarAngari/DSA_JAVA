class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        // Store final result
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two pointers
            int left = i + 1, right = n - 1;

            // Find pairs for current nums[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }
}
