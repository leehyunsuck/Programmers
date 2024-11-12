import java.util.*;

class Solution {
    private static int[][] dungeons;
    
    private static int answer;
    
    public void reset(int[][] arr) {
        this.dungeons = arr;
        this.answer = 0;
    }
    
    public void dfs(int k, int count, boolean[] used) {
        this.answer = Math.max(this.answer, count);
        
        for (int i = 0; i < this.dungeons.length; i++) {
            if (used[i]) continue;
            if (k < this.dungeons[i][0]) continue;
            
            used[i] = true;
            this.dfs(k - this.dungeons[i][1], count + 1, used);
            used[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        this.reset(dungeons);
        
        boolean[] used = new boolean[dungeons.length];
        dfs(k, 0, used);
        
        return this.answer;
    }
}

// 최소 필요 필로도 , 소모 피로도
