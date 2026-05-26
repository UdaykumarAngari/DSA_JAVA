class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;

        int n = matrix[0].length;

        int row = 0;

        int col = n - 1;

        while(row < m && col >= 0){

            int current = matrix[row][col];

            if(current == target){

                return true;
            }

            else if(current > target){

                col--;
            }

            else{

                row++;
            }
        }

        return false;
    }
}