class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long sum = 0;
        int n = squares.length;

        for (int i = 0; i < n / 2; i++) {
            sum -= squares[i];
        }

        for (int i = n / 2; i < n; i++) {
            sum += squares[i];
        }

        return sum;
    }
}