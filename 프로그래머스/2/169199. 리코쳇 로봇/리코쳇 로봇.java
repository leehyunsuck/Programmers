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
            
            int[][] newRCs = {
                {row - 1, col}, 
                {row + 1, col}, 
                {row, col - 1}, 
                {row, col + 1}
            };
            
            int[] check = {0, map.length, 0, map[0].length};
            
            for (int idx = 0; idx < newRCs.length; idx++) {
                int[] newRC = newRCs[idx];
                // 0보다 크거나 같은지 확인
                if (idx % 2 == 0) {
                    if (newRC[idx / 2] >= check[idx] && map[newRC[0]][newRC[1]] != 'D') {
                        for (; newRC[idx / 2] > check[idx]; newRC[idx / 2]--)
                            if (isD(newRC[0], newRC[1])) break;
                        if (isD(newRC[0], newRC[1])) newRC[idx / 2]++;
                        queue.offer(new int[] {newRC[0], newRC[1], moveCount + 1});
                    }
                } else {
                    if (newRC[idx / 2] < check[idx] && map[newRC[0]][newRC[1]] != 'D') {
                        for (; newRC[idx / 2] < check[idx] - 1; newRC[idx / 2]++) 
                            if (isD(newRC[0], newRC[1])) break;
                        if (isD(newRC[0], newRC[1])) newRC[idx / 2]--;
                        queue.offer(new int[] {newRC[0], newRC[1], moveCount + 1});
                    }
                }
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