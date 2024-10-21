import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Map<Integer, Integer> successMap = new HashMap<>();
        
        int minDay = 0;
        for (int i = 0; i < progresses.length; i++) {
            int day = 0;
                
            int progress = progresses[i];
            int speed = speeds[i];
            
            while (progress < 100) {
                day++;
                progress += speed;
            }
            if (day > minDay) minDay = day;
            else day = minDay;
            
            int getSuccessCount = successMap.getOrDefault(day, 0);
            successMap.put(day, getSuccessCount + 1);
        }
        
        int[] answer = new int[successMap.size()];
        Integer[] keys = successMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        
        int idx = 0;
        for (Integer key : keys) {
            answer[idx++] = successMap.get(key);
        }

        return answer;
    }
}