import java.util.*;

class Solution {
    private List<List<Integer>> graph;

    public void resetGraph(int n, int[][] computers) {
        graph = new ArrayList<>();
        
        for (int node = 0; node < computers.length; node++) {
            graph.add(new ArrayList<>());
            
            for (int linkNode = 0; linkNode < computers[node].length; linkNode++) {
                if (computers[node][linkNode] == 0) continue;
                graph.get(node).add(linkNode);
            }
        }
    }
    
    public int graphAllSearch() {
        int networkCount = 0;
   
        boolean[] visited = new boolean[graph.size()];
        for (int node = 0; node < graph.size(); node++) {
            if (visited[node]) continue;
            networkCount++;
            bfs(visited, node);
        }
        
        return networkCount;
    }
    
    public void bfs(boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            int pollNode = queue.poll();
            if (visited[pollNode]) continue;
            visited[pollNode] = true;
            
            for (Integer nextNode : graph.get(pollNode)) {
                if (visited[nextNode]) continue;
                queue.offer(nextNode);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        resetGraph(n, computers);
        return graphAllSearch();
    }
}