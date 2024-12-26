import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] board = createBoard(rows, columns);
        
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = runQuery(board, queries[idx]);
        }
        
        return answer;
    }
    
    public int runQuery(int[][] board, int[] query) {
        int x1 = query[0] - 1,
            y1 = query[1] - 1,
            x2 = query[2] - 1,
            y2 = query[3] - 1;
        
        int startValue = board[x1][y1];
        int minValue = startValue;
        
        // 좌열 상 이동
        for (int x = x1; x < x2; x++) {
            board[x][y1] = board[x + 1][y1];
            if (board[x][y1] < minValue)
                minValue = board[x][y1];
        }
        // 하행 좌 이동
        for (int y = y1; y < y2; y++) {
            board[x2][y] = board[x2][y + 1];
            if (board[x2][y] < minValue)
                minValue = board[x2][y];
        }
        // 우열 하 이동
        for (int x = x2; x > x1; x--) {
            board[x][y2] = board[x - 1][y2];
            if (board[x][y2] < minValue)
                minValue = board[x][y2];
        }
        // 상행 우 이동
        for (int y = y2; y > y1; y--) {
            board[x1][y] = board[x1][y - 1];
            if (board[x1][y] < minValue)
                minValue = board[x1][y];
        }
        board[x1][y1 + 1] = startValue;
        
        return minValue;
    }
    
    public int[][] createBoard(int row, int col) {
        int[][] result = new int[row][col];
        
        for (int r = 0, value = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                result[r][c] = value++;
            }
        }
        
        //printBoard(result);
        
        return result;
    }
    
    public void printBoard(int[][] board) {
        System.out.println("======= Board =======");
        for (int[] b : board)
            System.out.println(Arrays.toString(b));
    }
}