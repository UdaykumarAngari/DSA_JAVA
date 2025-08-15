package LeetCode_POTD.Math.LC_342_Power_of_Four;

public class Solution {
    public boolean isPowerOfFour(int n) {
        // Approach 1: Iterative Division (commented out)
        /*
         if (n <= 0) {
             return false;
         }
         while (n % 4 == 0) {
             n /= 4;
         }
         return n == 1;
        */

        // Approach 2: Bit Manipulation

        // 1. Edge Case Check: Powers of four must be positive.
        if (n <= 0) {
            return false;
        }

        // 2. Main Logic:
        //    Condition A: (n & (n - 1)) == 0  --> Checks if n is a power of two.
        //    Condition B: Integer.bitCount(n - 1) % 2 == 0 --> Checks if the exponent is even.
        // 3. If the conditions are not met, it's not a power of four.
        return (n & (n - 1)) == 0 && Integer.bitCount(n - 1) % 2 == 0;

    }
}
