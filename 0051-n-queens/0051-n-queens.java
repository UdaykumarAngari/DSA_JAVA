import java.util.*;

class Solution {
    public boolean isSafe(int row, int col, char[][] board, int n) {
         
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }
        
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
 
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public void solve(int col, char[][] board,
                      List<List<String>> ans, int n) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
 
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {

                board[row][col] = 'Q';    

                solve(col + 1, board, ans, n); 

                board[row][col] = '.';         
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, n);
        return ans;
    }
}
 
