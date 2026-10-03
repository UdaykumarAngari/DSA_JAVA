class Solution {
    int rows, cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int orginalColor = image[sr][sc];

        if(orginalColor == color) return image;

        //int[][] res = new int[rows][cols];
        
        dfs(sr, sc, image, orginalColor, color);

        return image;
    }

    public void dfs(int row, int col, int[][] image, int orginalColor, int color){
        image[row][col] = color;

        //top
        if(row > 0 && image[row - 1][col] == orginalColor){
            dfs(row - 1, col, image, orginalColor, color );
        }


        //bottom
        if(row < rows - 1 && image[row + 1][col] == orginalColor){
            dfs(row + 1, col, image, orginalColor, color );
        }

        //left 
        if(col > 0 && image[row][col - 1] == orginalColor){
            dfs(row, col - 1, image, orginalColor, color );
        }

        //top
        if(col < cols - 1 && image[row][col+1] == orginalColor){
            dfs(row, col + 1, image, orginalColor, color );
        }
    }




}