import java.util.*;

class Solution {
    private int[] start,
                  end;
    
    private char[][] map;
    
    public boolean isD(int row, int col) {
        return map[row][col] == 'D';
    }
    
    public int startBFS() {
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0], col = poll[1], moveCount = poll[2];
            
            // 찾음
            if (row == end[0] && col == end[1]) return moveCount;
            // 이미 조회
            if (visited[row][col]) continue;
            // 방문 처리
            visited[row][col] = true;
            
            // 상 하 좌 우
            int upRow = row - 1;
            if (upRow >= 0 && map[upRow][col] != 'D') {
                for (; upRow > 0; upRow--)
                    if (isD(upRow, col)) break;
                if (isD(upRow, col)) upRow++;
                queue.offer(new int[] {upRow, col, moveCount + 1});
            }
            
            int downRow = row + 1;
            if (downRow < map.length && map[downRow][col] != 'D') {
                for (; downRow < map.length - 1; downRow++)
                    if (isD(downRow, col)) break;
                if (isD(downRow, col)) downRow--;
                queue.offer(new int[] {downRow, col, moveCount + 1});
            }
            
            int leftCol = col - 1;
            if (leftCol >= 0 && map[row][leftCol] != 'D') {
                for (; leftCol > 0; leftCol--) 
                    if (isD(row, leftCol)) break;
                if (isD(row, leftCol)) leftCol++;
                queue.offer(new int[] {row, leftCol, moveCount + 1});
            }
            
            int rightCol = col + 1;
            if (rightCol < map[row].length && map[row][rightCol] != 'D') {
                for (; rightCol < map[row].length - 1; rightCol++)
                    if (isD(row, rightCol)) break;
                if (isD(row, rightCol)) rightCol--;
                queue.offer(new int[] {row, rightCol, moveCount + 1});
            }
        }
        
        return -1;
    }
    
    private void reset(String[] board) {
        map   = new char[board.length][board[0].length()];
        start = new int[0];
        end   = new int[0];
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length(); col++) {
                map[row][col] = board[row].charAt(col);
                
                if      (map[row][col] == 'R')  start = new int[] {row, col, 0};
                else if (map[row][col] == 'G')  end   = new int[] {row, col};
            }
        }
    }
    
    public void printInfo() {
        for (char[] m : map) 
            System.out.println(Arrays.toString(m).replace(",", ""));
        
        System.out.println("시작 지점 : " + Arrays.toString(start));
        System.out.println("종료 지점 : " + Arrays.toString(end));
    }
    
    
    
    public int solution(String[] board) {
        reset(board);
        return startBFS();
    }
}