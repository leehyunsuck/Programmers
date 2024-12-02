import java.util.*;

// N      : 마을 개수
// road[] : 다리 정보 [마을A 마을B 소모시간]
// K      : 이동 최대 시간

// 도로는 양방향 통행
class Solution {
    public int solution(int N, int[][] road, int K) {
        Set<Integer> answerSet = new HashSet<>();
        answerSet.add(1);
        
        // [로직1] - road 를 인접 마을 그래프화
        //        - 마을별 이동 시간 Map에 저장
        Map<String, Integer> timeMap = new HashMap<>();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : road) {
            int locationA = r[0],
                locationB = r[1],
                time      = r[2];
            
            graph.get(locationA).add(locationB);
            graph.get(locationB).add(locationA);
            
            String k1 = locationA + " " + locationB,
                   k2 = locationB + " " + locationA;
            
            timeMap.put(k1, Math.min(time, timeMap.getOrDefault(k1, Integer.MAX_VALUE)));
            timeMap.put(k2, Math.min(time, timeMap.getOrDefault(k2, Integer.MAX_VALUE)));
        }
        
        // [로직2] 1번 지역부터 이동해서 K 시간 이하인지 확인
        
        // 마을별 최소 시간 저장
        Map<Integer, Integer> minTimeMap = new HashMap<>();
        minTimeMap.put(1, 0);
        for (int i = 2; i <= N; i++) {
            minTimeMap.put(i, Integer.MAX_VALUE);
        }
        
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0}); // 시작지점, 시간
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            int location = poll[0],
                time     = poll[1];
            
            for (int nextLoc : graph.get(location)) {
                String key = location + " " + nextLoc;
                int moveTime = timeMap.get(key);
                int timeSum = time + moveTime;
                
                if (timeSum > K) continue;  // 시간 초과
                if (timeSum >= minTimeMap.get(nextLoc)) continue; // 이미 도착 이력 있는데 시간소모 같거나 더 큼
                
                minTimeMap.put(nextLoc, timeSum);
                answerSet.add(nextLoc);
                queue.offer(new int[] {nextLoc, timeSum});
            }
        }

        // return 음식 받을 수 있는 마을 개수 
        return answerSet.size();
    }
}
