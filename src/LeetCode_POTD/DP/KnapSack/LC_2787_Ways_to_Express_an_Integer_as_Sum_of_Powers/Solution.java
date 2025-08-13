package LeetCode_POTD.DP.KnapSack.LC_2787_Ways_to_Express_an_Integer_as_Sum_of_Powers;

import java.util.Arrays;

public class Solution {
    private static final int MOD = (int) 1e9 + 7;
    int[][] dp;

    public int solve(int remainingSum, int x, int currentNum) {
        // Base case: We've found a valid way to form the sum.
        if (remainingSum == 0) {
            return 1;
        }
        // Base case: We've overshot the target sum.
        if (remainingSum < 0) {
            return 0;
        }
        long currentPower = pow(currentNum, x);

        // Base case: The current number's power is too large.
        if (currentPower > remainingSum) {
            return 0;
        }

        // Check if this state has already been computed.
        if (dp[remainingSum][currentNum] != -1) {
            return dp[remainingSum][currentNum];
        }

        // Option 1: Take the current number's power.
        int take = solve((int)(remainingSum - currentPower), x, currentNum + 1) % MOD;
        // Option 2: Skip the current number's power and go to next number.
        int skip = solve(remainingSum, x, currentNum + 1) % MOD;

        // Store and return the sum of both options.
        return dp[remainingSum][currentNum] = (take + skip) % MOD;
    }

    // A helper function (binary exponentiation method) to calculate base^exponent efficiently.
    private long pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        long half = pow(base, exponent / 2);
        long result = half * half;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public int numberOfWays(int n, int x) {
        // Initialize the memoization table.
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        // Start the recursive process.
        return solve(n, x, 1);
    }
}