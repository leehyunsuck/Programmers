import java.util.*;

class Solution {
    class Road {
        public int row, 
                   col, 
                   dir, 
                   cost;
        
        public Road(int row, int col, int dir, int cost) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    private static final int COST_STRAIGHT = 100;   // 직선 비용
    private static final int COST_TURN = 600;       // 코너 비용 
    // 상, 하, 좌, 우
    private static final int[][] DRS = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] minCost = new int[n][n][4];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                Arrays.fill(minCost[row][col], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<Road> queue = new PriorityQueue<>( (r1, r2) -> r1.cost - r2.cost);
        queue.offer(new Road(0, 0, -1, 0)); 
        
        while (!queue.isEmpty()) {
            Road poll = queue.poll();
            
            int row  = poll.row, 
                col  = poll.col,
                dir  = poll.dir,
                cost = poll.cost;
            
            if (dir != -1 && minCost[row][col][dir] < cost) continue;
            if (row == n - 1 && col == n - 1) return cost;
            
            for (int nextDir = 0; nextDir < DRS.length; nextDir++) {
                int nextRow = row + DRS[nextDir][0],
                    nextCol = col + DRS[nextDir][1];
                
                if (nextRow < 0 || nextRow >= n) continue;  // 장외
                if (nextCol < 0 || nextCol >= n) continue;  // 장외
                if (board[nextRow][nextCol] == 1) continue; // 벽
                
                int nextCost = cost + ((dir == -1 || dir == nextDir) ? COST_STRAIGHT : COST_TURN);
                
                if (nextCost < minCost[nextRow][nextCol][nextDir]) {
                    minCost[nextRow][nextCol][nextDir] = nextCost;
                    queue.offer(new Road(nextRow, nextCol, nextDir, nextCost));
                }
            }
        }
        
        return 0;
    }
}