class Solution {
    int rows, cols;
    int time = -1;

    int[][] directions = {
        {-1, 0}, // up
        {1, 0}, // down
        {0, -1}, // left
        {0, 1} // right
    };

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int fresh = 0;


        Queue<int[]> q = new LinkedList<>();

        for(int row = 0 ; row < rows ; row++){
            for(int col = 0; col < cols ; col++){
                if(grid[row][col] == 2){
                    q.add(new int[]{row, col}); // storing rotten oranges
                }
                else if(grid[row][col] == 1) {
                    fresh++; // checking if no fresh oranges are there [[0]] case
                }
            }
        }

        if(fresh == 0) return 0;

        bfs(grid, q);

        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
            }
        }

        return time;


    }

    public void bfs(int[][] grid, Queue<int[]> q ){
        
        while(!q.isEmpty()){

            int size = q.size(); // defined here because queue size is decreased on polling the elements which would result in wrong answers

    
            for(int i = 0 ; i < size ; i++){
                // getting the current row, col
                int[] cell = q.poll();

                int row = cell[0];
                int col = cell[1];
                

                //moving in adjacent cells
                for(int[] dir : directions){
                    
                    //checking in the new directions
                    int newRow = row + dir[0]; 
                    int newCol = col + dir[1];

                    //boundary conditions
                    if(newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols){
                        continue;
                    }

                    // if the current ele is fresh orange we make it rotten orange and add the newRotten orange to the queue to check further 
                    if(grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                    }    
                }
            }
            // updating time at each level
            time++;
        }
    }
}