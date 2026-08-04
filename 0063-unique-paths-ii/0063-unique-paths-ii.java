class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if( grid[0][0]==1 ) return 0;

        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==0 && j==0) continue;
                if(grid[i][j]!=1){
                    dp[i][j] = ((j>0) ? dp[i][j-1] : 0 ) +
                     ((i>0) ? dp[i-1][j] : 0);
                }
            }

        }
        return dp[m-1][n-1];
    }
}