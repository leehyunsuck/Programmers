import java.util.*;

class Solution {
    private static final int[][] DIRS = {{'d', 1, 0}, {'l', 0, -1}, {'r', 0, 1}, {'u', -1, 0}};
    
    private String answer = "impossible";
    private int n, m, r, c, k;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n; this.m = m; this.r = r; this.c = c; this.k = k;
        
        dfs(new StringBuilder(), x, y);
        return answer;
    }
    
    private void dfs(StringBuilder builder, int row, int col) {
        if (row < 1 || col < 1) return;
        if (row > n || col > m) return;
        if (!answer.equals("impossible")) return;
        if (!canGetToExit(builder, row, col)) return;
        
        if (builder.length() == k) {
            if (row == r && col == c) answer = builder.toString();
            return;
        }
        
        for (int[] dir : DIRS) {
            builder.append((char) dir[0]);
            dfs(builder, row + dir[1], col + dir[2]);
            builder.deleteCharAt(builder.length() - 1);
        }    
    }
    
    private boolean canGetToExit(StringBuilder builder, int row, int col) {
        int canMoveCount = k - builder.length();
        int needMoveCount = Math.abs(r - row) + Math.abs(c - col);
        
        if (canMoveCount < needMoveCount) return false;
        return (canMoveCount - needMoveCount) % 2 == 0;
    }
}
