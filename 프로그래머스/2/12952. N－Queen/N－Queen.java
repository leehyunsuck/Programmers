import java.util.*;

class Solution {
    private int answer = 0;
    
    public int solution(int n) {
        dfs(new boolean[n][n], 0, n);
        
        return answer;
    }
    
    private void dfs(boolean[][] board, int row, int count) {
        if (!isFollowRules(board)) return;
        
        if (count == 0) {
            /*
            for (boolean[] b : board) {
                System.out.println(Arrays.toString(b));
            }
            System.out.println();
            */
            answer++;
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            board[row][col] = true;
            dfs(board, row + 1, count - 1);
            board[row][col] = false;
        }
    }
    
    private boolean isFollowRules(boolean[][] board) {
        int n = board.length;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!board[row][col]) continue;
                
                // 가로 체크
                for (int r = row + 1; r < n; r++) {
                    if (board[r][col]) return false;
                }
                
                // 세로 체크
                for (int c = col + 1; c < n; c++) {
                    if (board[row][c]) return false;
                }
                
                // 우하 대각선 체크 
                for (int r = row + 1, c = col + 1; r < n && c < n; r++, c++) {
                    if (board[r][c]) return false;
                }
                
                // 좌하 대각선 체크
                for (int r = row + 1, c = col - 1; r < n && c >= 0; r++, c--) {
                    if (board[r][c]) return false;
                }
            }
        }
        return true;
    }
}