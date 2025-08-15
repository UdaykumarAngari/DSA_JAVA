package LeetCode_POTD.Math.LC_342_Power_of_Four;

public class Solution {
    public boolean isPowerOfFour(int n) {
        //Approach 1
         /*if (n <= 0) {
             return false;
         }
         while (n % 4 == 0) {
             n /= 4;
         }
         return n == 1;*/


        if(n<=0) return false;

        if((n&(n-1)) == 0 && Integer.bitCount(n-1)%2==0) return true;

        return false;

    }
}
