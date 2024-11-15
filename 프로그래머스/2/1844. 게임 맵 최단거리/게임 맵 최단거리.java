import java.util.*;

class Solution {
    
    private static final int[][] dxy = {
        {1, 0}, {-1, 0}, {0, -1}, {0, 1}
    };
    
    public int solution(int[][] maps) {
        boolean[][] used = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1}); // x, y, count
        used[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0],
                y = poll[1],
                count = poll[2];
            
            if (x == maps.length - 1 && y == maps[0].length - 1) return count;
            
            for (int[] xy : dxy) {
                int tempX = x + xy[0],
                    tempY = y + xy[1];
                
                // 장외
                if (tempX < 0 || tempY < 0) continue;   
                if (tempX >= maps.length || tempY >= maps[0].length) continue;
                
                // 벽
                if (maps[tempX][tempY] == 0) continue;
                
                // 이미 방문
                if (used[tempX][tempY]) continue;
                
                used[tempX][tempY] = true;
                queue.offer(new int[] { tempX, tempY, count + 1});
            }
        }
        
        return -1;
    }
}