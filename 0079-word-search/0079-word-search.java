class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(wordSearch(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean wordSearch(int i, int j, int curr, String word, char[][] board){
        if(curr == word.length()) {
            return true;
        }

        if(i<0 || i>= board.length ||  j<0 || j>= board[0].length || board[i][j] != word.charAt(curr) ){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = (wordSearch(i + 1, j, curr + 1, word, board) ||
                        wordSearch(i - 1, j, curr + 1, word, board) ||
                        wordSearch(i, j + 1, curr + 1, word, board) ||
                        wordSearch(i, j - 1, curr + 1, word, board)
        );
        board[i][j] = temp;

        return found;
    }
    
}