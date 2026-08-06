class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }

        return solve(0, 0, n - 1, m, n, grid, dp);
    }

    public int solve(int i, int j1, int j2, int m, int n, int[][] g, int[][][] dp) {

        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
            return (int)-1e9;

        if (i == m - 1) {
            if (j1 == j2)
                return g[i][j1];
            return g[i][j1] + g[i][j2];
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int curr = (j1 == j2) ? g[i][j1] : g[i][j1] + g[i][j2];

        int max = (int)-1e9;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int ans = curr + solve(i + 1, j1 + dj1, j2 + dj2, m, n, g, dp);
                max = Math.max(max, ans);
            }
        }

        return dp[i][j1][j2] = max;
    }
}