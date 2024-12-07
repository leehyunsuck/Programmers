import java.util.*;

class Solution{
    public int solution(int[][] board) {
        int maxLen = 0;
        
        for (int row = 0; row < board.length; row++)
            maxLen = Math.max(maxLen, board[row][0]);
        for (int col = 0; col < board[0].length; col++)
            maxLen = Math.max(maxLen, board[0][col]);
        
        for (int row = 1; row < board.length; row++) {
            for (int col = 1; col < board[row].length; col++) {
                if (board[row][col] == 0) continue;
                board[row][col] = Math.min(Math.min(board[row-1][col], board[row][col-1]), board[row-1][col-1]) + 1;
 
                maxLen = Math.max(maxLen, board[row][col]);
            }
        }
        
        return maxLen * maxLen;
    }
}
/*
import java.util.*;

class Solution{
    private int maxLen;
    
    public int[][] getResetDP(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        
        for (int row = 0; row < board.length; row++) {
            dp[row][0] = board[row][0];
            maxLen = Math.max(maxLen, dp[row][0]);
        }
        for (int col = 0; col < board[0].length; col++) {
            dp[0][col] = board[0][col];
            maxLen = Math.max(maxLen, dp[0][col]);
        }
        
        return dp;
    }
    
    public int getMin(int[][] dp, int row, int col) {
        int min1 = Math.min(dp[row-1][col], dp[row][col-1]);
        return Math.min(min1, dp[row-1][col-1]);
    }
    
    public int solution(int[][] board) {
        maxLen = 0;
        
        int[][] dp = getResetDP(board);

        for (int row = 1; row < board.length; row++) {
            for (int col = 1; col < board[row].length; col++) {
                if (board[row][col] == 0) continue;
                
                dp[row][col] = getMin(dp, row, col) + 1;
                maxLen = Math.max(maxLen, dp[row][col]);
            }
        }
        
        return maxLen * maxLen;
    }
}
*/

/*

import java.util.*;

class Solution{
    public int solution(int[][] board) {
        int maxLen = 0;

        // 보드 탐색
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 0) continue;
                
                // 현재 찾은 길이 이상 못찾는 값임
                if (row + maxLen >= board.length ||
                    col + maxLen >= board[row].length) continue;
                
                maxLen = Math.max(maxLen, findSquare(board, row, col));
            }
        }

        return (int) Math.pow(maxLen, 2);
    }
    
    public int findSquare(int[][] board, int row, int col) {
        int result = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row + 1, col});
        queue.offer(new int[] {row, col + 1});
        queue.offer(new int[] {row + 1, col + 1});
        queue.offer(null);
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll == null) {
                result++;
                queue.offer(null);
                continue;
            }
            
            // 장외
            if (poll[0] < 0 || poll[0] >= board.length ||
                poll[1] < 0 || poll[1] >= board[poll[0]].length) break;
            // 꽉 채워진 사각형 아님
            if (board[poll[0]][poll[1]] == 0) break;
            // 이미 방문함
            if (visited[poll[0]][poll[1]]) continue;
            visited[poll[0]][poll[1]] = true;
            
            queue.offer(new int[] {poll[0] + 1, poll[1]});
            queue.offer(new int[] {poll[0], poll[1] + 1});
            queue.offer(new int[] {poll[0] + 1, poll[1] + 1});
        }
        return result;
    }
}
*/