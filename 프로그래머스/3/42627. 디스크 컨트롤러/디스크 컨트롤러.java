import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a1, a2) -> a1[0] - a2[0]);
        
        // {고유번호, 요청시간, 필요시간}
        PriorityQueue<int[]> jobPriQueue = new PriorityQueue<>( (a1, a2) -> {
            int useTimeCompare = a1[2] - a2[2];
            if (useTimeCompare != 0) return useTimeCompare;             // 우선순위1. 사용시간 짧음
            int requestTimeCompare = a1[1] - a2[1];
            if (requestTimeCompare !=   0) return requestTimeCompare;   // 우선순위2. 요청시간 빠름
            return a1[0] - a2[0];                                       // 우선순위3. 작업번호 작음
        });
        
        int ms = 0,
            sumWaitMS = 0;
        
        int idx = 0;
        while (idx < jobs.length || !jobPriQueue.isEmpty()) {
            while (idx < jobs.length && jobs[idx][0] <= ms) {
                jobPriQueue.offer(new int[] {idx, jobs[idx][0], jobs[idx++][1]});
            }
            
            if (jobPriQueue.isEmpty()) {
                ms = jobs[idx][0];
                continue;
            }
 
            int[] poll = jobPriQueue.poll();
            ms += poll[2];
            sumWaitMS += ms - poll[1];
        }
        
        return sumWaitMS / jobs.length;
    }
}

// 작업 요청 (번호, 요청시각, 소요시간) 대기 큐 있음

// 소요시간 짧은것 -> 요청시각 빠른것 -> 작업 번호 작은 것

// 한번 시작하면 그거 먼저 다 끝냄

// 끝나는 시점 + 들어오는 시점 겹치면 요청을 대기큐에 저장

// 평균 반환 시간