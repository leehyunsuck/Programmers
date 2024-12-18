import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        int big = 0;
        
        Map<Integer, Integer> workMap = new HashMap<>();
        for (int work : works) {
            workMap.put(work, workMap.getOrDefault(work, 0) + 1);
            big = Math.max(big, work);
        }
        
        for (; n > 0 && big > 0; n--) {
            int count = workMap.get(big);
            workMap.put(big, count - 1);
            workMap.put(big-1, workMap.getOrDefault(big-1, 0) + 1);
            
            if (count - 1 == 0) big--;
        }
        
        long answer = 0L;
        for (Integer workTime : workMap.keySet()) {
            for (int count = workMap.get(workTime); count > 0; count--)
                answer += Math.pow(workTime, 2);
        }
        
        return answer;
    }
}

/*
        // 초기값 세팅
        Queue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) 
            pQueue.offer(work);
        
        // 시간이 가장 많이 필요한것부터 처리 
        for (; n > 0 && !pQueue.isEmpty(); n--) {
            int poll = pQueue.poll();
            if (poll > 1) pQueue.offer(poll - 1);
        }
        
        // 일 못끝낸건 피로도임, (제곱)
        long answer = 0L;
        while (!pQueue.isEmpty()) 
            answer += Math.pow(pQueue.poll(), 2);
        
        return answer;

테스트 1 〉	통과 (0.99ms, 86.2MB)
테스트 2 〉	통과 (0.50ms, 89MB)
테스트 3 〉	통과 (0.67ms, 85.2MB)
테스트 4 〉	통과 (0.72ms, 73.6MB)
테스트 5 〉	통과 (0.46ms, 85.2MB)
테스트 6 〉	통과 (0.48ms, 93.5MB)
테스트 7 〉	통과 (0.70ms, 89.9MB)
테스트 8 〉	통과 (2.20ms, 79.6MB)
*/