import java.util.*;

// 아 뭔 좌측 상단이 1,1이야
// 제대로 안읽은 잘못 시간으로 벌받았다

class Solution {
    // 사전순 순서로 방향 설정: 'd', 'l', 'r', 'u'
    private static final int[][] DIRS = {
        {1, 0, 'd'}, {0, -1, 'l'}, {0, 1, 'r'}, {-1, 0, 'u'}
    };
    
    private String answer = "impossible";
    private int n, m, r, c, k;
    
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n; this.m = m; this.r = r; this.c = c; this.k = k;
        
        dfs(x, y, new StringBuilder());
        
        return answer;
    }
    
    private void dfs(int row, int col, StringBuilder builder) {
        if (!answer.equals("impossible")) return;   // 최초 발견이 사전순 첫번째임
        
        if (builder.length() == k) {
            if (row == r && col == c) answer = builder.toString();
            return;
        }
        
        int canMoveCount  = k - builder.length(),                   // 움직일 수 있는 횟수
            needMoveCount = Math.abs(r - row) + Math.abs(c - col);  // 필요한 횟수
        
        if (canMoveCount < needMoveCount) return;                   // 걍 물리적으로 갈수 없음
        if ((canMoveCount - needMoveCount) % 2 == 1) return;        // 상하좌우 밖에 없으니 1칸 남으면 못감
        
        for (int[] moveInfo : DIRS) {
            int nextRow = row + moveInfo[0],
                nextCol = col + moveInfo[1];
            
            if (nextRow < 1 || nextCol < 1) continue;
            if (nextRow > n || nextCol > m) continue;
            
            builder.append((char) moveInfo[2]);
            dfs(nextRow, nextCol, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
