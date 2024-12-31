class Solution {
    public int solution(String[] board) {
        int o = 0,
            x = 0;
        for (String r : board) {
            for (char c : r.toCharArray()) {
                if      (c == 'O') o++;
                else if (c == 'X') x++;
            }
        }
        
        if (!(o - x == 1 || o - x == 0)) return 0;
        
        char[][] charBoard = new char[3][3];
        for (int idx = 0; idx < 3; idx++)
            charBoard[idx] = board[idx].toCharArray();
        boolean oWin = isWin(charBoard, 'O'),
                xWin = isWin(charBoard, 'X');
        
        if (oWin && xWin) return 0;
        if (oWin && o != x + 1) return 0;
        if (xWin && o != x) return 0;
        
        return 1;
    }
    
    private boolean isWin(char[][] board, char target) {
        if (target == board[0][0] 
            && board[0][0] == board[1][1] 
            && board[1][1] == board[2][2]) return true;
        if (target == board[0][2] 
            && board[0][2] == board[1][1] 
            && board[1][1] == board[2][0]) return true;
        
        for (int row = 0; row < 3; row++) {
            if (target == board[row][0] 
                && board[row][0] == board[row][1] 
                && board[row][1] == board[row][2]) return true;
        }
        
        for (int col = 0; col < 3; col++) {
            if (target == board[0][col] 
                && board[0][col] == board[1][col]
                && board[1][col] == board[2][col]) return true;
        }
        
        return false;
    }
}