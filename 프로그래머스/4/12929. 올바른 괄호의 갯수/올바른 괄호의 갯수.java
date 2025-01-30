import java.util.*;

class Solution {
    public int solution(int n) {
        return n == 1 ? 1 : dfs(0, 0, n * 2);
    }
    
    private int dfs(int open, int close, int max) {
        if (close > open)        return 0;
        if (open + close == max) return open == close ? 1 : 0;
        return dfs(open + 1, close, max) + dfs(open, close + 1, max);
    }
}