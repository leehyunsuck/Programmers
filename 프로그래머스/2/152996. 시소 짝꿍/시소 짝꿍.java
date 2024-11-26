import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Long> wCountMap = new HashMap<>();
        for (int w : weights)
            wCountMap.put(w, wCountMap.getOrDefault(w, 0L) + 1);
        
        for (int w : wCountMap.keySet()) {
            long count = wCountMap.get(w);
            
            // 1 : 1    
            if (count >= 2) 
                answer += count * (count - 1) / 2;
            
            // 1 : 2   1:2==f:s   2f == s
            answer += count * wCountMap.getOrDefault(w * 2, 0L);
            
            // 2 : 3   2:3==f:S   3f == 2s
            if (w * 3 % 2 == 0)
                answer += count * wCountMap.getOrDefault(w * 3 / 2, 0L);
            
            // 3 : 4   3:4==f:s   4f == 3s
            if (w * 4 % 3 == 0)
                answer += count * wCountMap.getOrDefault(w * 4 / 3, 0L);
        }

        return answer;
    }
}
