class Solution {
    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        while(n >= d) {

            long temp = d;
            long multiple = 1;

            while(n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            n -= temp;
            quotient += multiple;
        }

        if((dividend < 0) ^ (divisor < 0)) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}