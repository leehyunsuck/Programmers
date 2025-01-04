import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<List<int[]>> graph = new ArrayList<>();
        resetGraph(graph, n, costs);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        queue.offer(new int[] {0, 0});
        
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            int location = poll[0],
                cost = poll[1];
            
            if (visited[location]) continue;
            visited[location] = true;
            
            answer += cost;
            count++;
            
            if (count == n) break;
            
            for (int[] nextInfo : graph.get(location)) {
                int nextL = nextInfo[0],
                    nextC = nextInfo[1];
            
                if (!visited[nextL])
                    queue.offer(new int[] {nextL, nextC});
            }
        }
 
        return answer;
    }
    
    private void resetGraph(List<List<int[]>> graph, int n, int[][] costs) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] cost : costs) {
            // [0] : 지역A, [1] : 지역B, [2] : 건설비용
            graph.get(cost[0]).add(new int[] {cost[1], cost[2]});
            graph.get(cost[1]).add(new int[] {cost[0], cost[2]});
        }
    }
}