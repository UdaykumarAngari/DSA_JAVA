class Solution {
    public boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i][i] > maxi && isPrime(nums[i][i])) {
                maxi = nums[i][i];
            }

            if (nums[i][n - i - 1] > maxi &&
                isPrime(nums[i][n - i - 1])) {
                maxi = nums[i][n - i - 1];
            }
        }

        return maxi;
    }
}