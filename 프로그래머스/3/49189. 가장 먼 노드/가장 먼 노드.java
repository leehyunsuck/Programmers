import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        resetGraph(graph, edge, n);
 
        return bfs(graph);
    }
    
    private int bfs(List<List<Integer>> graph) {
        int[] visited = new int[graph.size()];
        for (int idx = 0; idx < visited.length; idx++)
            visited[idx] = -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        visited[1] = 0;
        
        int maxMove = 0,
            count = 1;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            poll[1]++;
            
            for (int nextLocation : graph.get(poll[0])) {
                if (visited[nextLocation] != -1) continue;

                visited[nextLocation] = poll[1];
                queue.offer(new int[] {nextLocation, poll[1]});
                
                if (poll[1] < maxMove) continue;
                if (poll[1] == maxMove) count++;
                else {
                    maxMove = poll[1];
                    count = 1;
                }
            }
        }
        
        return count;
    }
    
    private void resetGraph(List<List<Integer>> graph, int[][] edge, int n) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
    }
}