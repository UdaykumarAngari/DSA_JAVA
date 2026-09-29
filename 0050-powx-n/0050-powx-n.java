class Solution {

    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private double power(double x, long n) {

        if (n == 0) {
            return 1;
        }

        double half = power(x, n / 2);


        //even power
        if (n % 2 == 0) {
            return half * half;
        }
        
        // odd power
        return x * half * half;
    }
}