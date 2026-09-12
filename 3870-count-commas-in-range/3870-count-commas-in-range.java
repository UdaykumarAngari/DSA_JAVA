class Solution {
    public int countCommas(int n) {
        int count = 0;

        for (long start = 1000; start <= n; start *= 1000) {
            count += n - start + 1;
        }

        return count;
    }
}