class Solution {
    boolean[][][] visited;
    int ans = Integer.MAX_VALUE;

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        visited = new boolean[m][n][1024];

        dfs(grid, 0, 0, 0);

        return ans;
    }

    void dfs(int[][] grid, int i, int j, int xor) {
        xor ^= grid[i][j];

        if (visited[i][j][xor]) {
            return;
        }

        visited[i][j][xor] = true;

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            ans = Math.min(ans, xor);
            return;
        }

        if (i + 1 < grid.length) {
            dfs(grid, i + 1, j, xor);
        }

        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1, xor);
        }
    }
}