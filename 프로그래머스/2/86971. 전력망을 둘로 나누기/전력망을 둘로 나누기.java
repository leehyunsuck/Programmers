import java.util.*;

class Solution {
    private List<List<Integer>> graph;
    
    private void resetGraph(int n, int[][] wires) {
        graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) 
            graph.add(new ArrayList<>());    
        for (int[] wire : wires) 
            connect(wire);
    }
    
    private void connect(int[] wire) {
        graph.get(wire[0]).add(wire[1]);
        graph.get(wire[1]).add(wire[0]);
    }
    
    private void disconnect(int[] wire) {
        graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
        graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
    }
    
    private int getCanVisitCount(int[] wire) {
        int canVisit = 0;
        
        boolean[] visited = new boolean[graph.size()];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(wire[0]);
        visited[wire[0]] = true;

        while (!queue.isEmpty()) {
            int area = queue.poll();
            canVisit++;
            
            for (int a : graph.get(area)) {
                if (visited[a]) continue;
                
                queue.offer(a);
                visited[a] = true;
            }
        }
        
        return canVisit;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        resetGraph(n, wires);
        
        for (int[] wire : wires) {
            disconnect(wire);
            int canVisit = getCanVisitCount(wire);
            answer = Math.min(answer, Math.abs(canVisit - (n - canVisit)));
            connect(wire);
        }
         
        return answer;
    }
}