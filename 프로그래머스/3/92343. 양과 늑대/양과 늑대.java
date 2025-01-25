// 채점 후 가독성 향상 연습

import java.util.*;

class Solution {
    private class Info {
        // 값 사용 여부
        boolean[] used;
        // 카운팅 및 현재 위치
        int wolf, sheep, nowIdx; 
        
        // 루트 생성자
        Info(boolean[] used) {
            this.used = used;
            this.wolf = this.sheep = this.nowIdx = 0;
        }
        
        // 다음 정보 생성자
        Info(Info info, int nowIdx) {
            this.used = info.used.clone();
            this.wolf = info.wolf;
            this.sheep = info.sheep;
            this.nowIdx = nowIdx;
        }
        
        void use(int[] info) {
            if (used[nowIdx]) return;
            if (info[nowIdx] == 0) sheep++;
            else wolf++;
            used[nowIdx] = true;
        }
        
        // 왜 String.format이나 '+' 연산으로 안하냐는 질문 금지
        // 이게 더 빨라
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(nowIdx).append(",").append(wolf).append(",").append(sheep).append(",");
            for (boolean b : used)
                builder.append(b ? "1" : "0");
            return builder.toString();
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        List<List<Integer>> graph = createGraph(edges, info.length);
        
        return getMaxSheapCount(graph, info);
    }
    
    // 그래프 탐색
    private int getMaxSheapCount(List<List<Integer>> graph, int[] info) {
        int result = 0;
        
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(new boolean[info.length]));
        
        // 동일한 조건으로 방문했는지 판단하기 위해 사용
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            poll.use(info);

            if (!validateRuleAndVisited(poll, visited)) continue;
            visited.add(poll.toString());
            
            result = Math.max(result, poll.sheep);
            
            for (int idx : graph.get(poll.nowIdx))
                queue.offer(new Info(poll, idx));
        }
        
        return result;
    }
    
    private boolean validateRuleAndVisited(Info info, Set<String> visited) {
        return info.wolf < info.sheep && !visited.contains(info.toString());
    }
    
    // 그래프 생성
    private List<List<Integer>> createGraph(int[][] edges, int len) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < len; i++) 
            graph.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}