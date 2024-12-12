import java.util.*;

class Solution {
    private int answer;
    private Map<Integer, int[]> useMap;
    private String[] minerals;
    
    public int solution(int[] picks, String[] minerals) {
        reset(minerals);
        dfs(picks, 0, 0);
        return answer;
    }
    
    public void dfs(int[] picks, int idx, int use) {
        if (idx >= minerals.length || (picks[0] + picks[1] + picks[2] == 0)) {
            setMinAnswer(use);
            return;
        }
        
        // i == pick(곡괭이) 종류
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) continue;
            int copyUse = use;
            
            int[] clone = picks.clone();
            clone[i]--;

            // j == 탐색하는 인덱스번호
            for (int j = idx; j < idx + 5 && j < minerals.length; j++) {
                char mine = minerals[j].charAt(0);
                copyUse += useMap.get(i)[(mine == 'd' ? 0 : ((mine == 'i') ? 1 : 2))];
            }
            
            dfs(clone, idx + 5, copyUse);
        }
    }
    
    public void setMinAnswer(int use) {
        answer = Math.min(answer, use);
    }

    
    public void reset(String[] minerals) {
        useMap = new HashMap<>();
        useMap.put(0, new int[] {1, 1, 1});
        useMap.put(1, new int[] {5, 1, 1});
        useMap.put(2, new int[] {25, 5, 1});
        
        answer = Integer.MAX_VALUE;
        
        this.minerals = minerals;
    }
}