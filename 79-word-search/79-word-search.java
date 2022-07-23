class Solution {
    
    final static int[] adder = {-1, 0, 1, 0, -1};
    
    class index {
        int i, j;
        public index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(wordPresent(0, i, j, board, ch)) return true;
            }
        }
        
        return false;
    }
    
    public boolean wordPresent(int idx, int i, int j, char[][] board, char[] word) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0
            || word[idx] != board[i][j]) return false;
        
        if(idx == word.length - 1) {
            return true;
        }
        
        char ch = board[i][j];
        board[i][j] = ' ';
        
        for(int k = 0; k < 4; k++) {
            if(wordPresent(idx + 1, i + adder[k], j + adder[k + 1], board, word)) return true;
        }
        
        board[i][j] = ch;
        
        return false;
    }
}