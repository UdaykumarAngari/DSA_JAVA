package LeetCode_POTD.Math.LC_326_Power_of_Three;

class Solution {

    // Approach 1: Iterative Division
    /*
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }
    */

    // Approach 2: Recursive Division
    /*
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }
    */

    // Approach 3: Logarithms
    /*
    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.abs(Math.log(n) / Math.log(3) - Math.round(Math.log(n) / Math.log(3))) < 1e-10;
    }
    */

    // Approach 4: Maximum Power of Three (Constant Time)
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
