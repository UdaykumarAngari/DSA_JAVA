class Solution {
    int rows, cols;
    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int enclaves = 0;

        // making boundaries as water and marking the path connected to boundary as water
        for(int row = 0 ; row < rows ; row++){
            dfs(row, 0, grid); 
            dfs(row, cols - 1, grid);
        }

        for(int col = 0 ; col < cols ; col++){
            dfs(0, col, grid);
            dfs(rows - 1, col, grid);
        }

        for(int i = 0;  i < rows; i++){
            for(int j = 0 ; j < cols ; j++){
                enclaves += grid[i][j]; // adding the cells (1s) that cant reach boundary 
            }
        }

        return enclaves;



    }

    public void dfs(int row, int col, int[][] grid){

        //check if it is out of boundary or a water cell if true dont go further

        if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0){
            return ;
        }

        //make the current cell as water
        grid[row][col] = 0;

        //traverse the remaining lands 

        //up

        dfs(row - 1, col, grid);

        //down
        dfs(row + 1, col, grid);

        //left
        dfs(row, col - 1 , grid);

        //right
        dfs(row, col + 1, grid);

    }
}