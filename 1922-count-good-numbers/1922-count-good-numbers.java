class Solution {
    
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        if(n==1) return 5;

        long even = (n + 1) /2;
        long odd = n / 2;

        long ans = (power(5, even)*power(4, odd)) % MOD;

        return (int) ans;

    }

    public long power(long base, long exp) {
        long ans = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            exp /= 2;
        }

        return ans;
    }

}