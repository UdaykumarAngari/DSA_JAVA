class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] mat = new int[m][n];
        int[][] xCount = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 'X') {
                    mat[i][j]=1;
                    xCount[i][j]=1;
                }
                else if(grid[i][j] == 'Y') mat[i][j]=-1;
            }
        }

        // prefix sum
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j<n;j++){
                if(i > 0){
                    mat[i][j] += mat[i-1][j];
                    xCount[i][j] += xCount[i-1][j];
                }
                if(j > 0){
                    mat[i][j] += mat[i][j-1];
                    xCount[i][j] += xCount[i][j-1];
                }
                if(i > 0 && j > 0){
                    mat[i][j] -= mat[i-1][j-1];
                    xCount[i][j] -= xCount[i-1][j-1];
                }
            }
        }

        int cnt = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j< n ; j++){
                if(mat[i][j]==0 && xCount[i][j] > 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}