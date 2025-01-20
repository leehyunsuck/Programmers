import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<List<Integer>> winGraph  = new ArrayList<>(),
                            loseGraph = new ArrayList<>();
        resetGraph(winGraph, loseGraph, results, n);
        
        //printGraph(winGraph, "WinGraph");
        //printGraph(loseGraph, "LoseGraph");
        
        for (int player = 1; player <= n; player++) {
            int winCount  = getVisitCountBFS(winGraph, player),
                loseCount = getVisitCountBFS(loseGraph, player);
            
            if (winCount + loseCount + 1 == n)
                answer++;
        }
        
        return answer;
    }
    
    private int getVisitCountBFS(List<List<Integer>> graph, int target) {
        int result = 0;
        
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        visited[target] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph.get(now)) {
                if (visited[next]) continue;
                queue.offer(next);
                visited[next] = true;
                result++;
            }
        }
        
        return result;
    }
    
    private void printGraph(List<List<Integer>> graph, String prefix) {
        System.out.println(String.format("[%s] Print Graph", prefix));
        
        for (int row = 1; row < graph.size(); row++) {
            System.out.print(row + " : ");
            for (int value : graph.get(row))
                System.out.print(value + ", ");
            System.out.println();
        }
    }
    
    private void resetGraph(List<List<Integer>> winGraph, List<List<Integer>> loseGraph, int[][] infos, int n) {
        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }
  
        for (int[] info : infos) {
            int win  = info[0],
                lose = info[1];
            
            winGraph.get(win).add(lose);
            loseGraph.get(lose).add(win);
        }
    }
}