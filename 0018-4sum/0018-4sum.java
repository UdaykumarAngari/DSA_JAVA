class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        // First loop - pick first number
        for (int i = 0; i < n; i++) {

            // Second loop - pick second number
            for (int j = i + 1; j < n; j++) {

                // HashSet for numbers between j and k
                HashSet<Integer> seen = new HashSet<>();

                // Third loop - pick third number
                for (int k = j + 1; k < n; k++) {

                    // Find required fourth number (use long to avoid overflow)
                    long required = (long) target
                                  - (long) nums[i]
                                  - (long) nums[j]
                                  - (long) nums[k];

                    // If required number already seen → valid quadruplet
                    // (check range before casting to int)
                    if (required >= Integer.MIN_VALUE && required <= Integer.MAX_VALUE
                            && seen.contains((int) required)) {

                        List<Integer> temp = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k],
                                (int) required
                        );

                        Collections.sort(temp);
                        set.add(temp);
                    }

                    // Add current third number into set
                    seen.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}