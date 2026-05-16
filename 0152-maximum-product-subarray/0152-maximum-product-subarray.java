class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int max = nums[0];

        for(int i = 0; i < n; i++){

            int prod = 1;

            for(int j = i; j < n; j++){

                prod *= nums[j];

                max = Math.max(max, prod);
            }
        }

        return max;
    }
}