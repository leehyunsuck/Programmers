import java.util.*;

class Solution {
    private class Edge {
        int linked, cost;
        
        Edge(int linked, int cost) {
            this.linked = linked;
            this.cost   = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Edge>> graph = generateGraph(n, fares);
        
        int[] startS = visitMinCost(graph, s),
              startA = visitMinCost(graph, a),
              startB = visitMinCost(graph, b);
        
        int answer = Integer.MAX_VALUE;
        boolean change = false;
        // 1번~n번 까지 같이가고 흩어질 때 계산해서 최소 비용
        for (int mid = 1; mid <= n; mid++) {
            if (startS[mid] == Integer.MAX_VALUE ||
                startA[mid] == Integer.MAX_VALUE ||
                startB[mid] == Integer.MAX_VALUE) continue;
            answer = Math.min(answer, startS[mid] + startA[mid] + startB[mid]);
            change = true;
        }
        
        if (!change) throw new RuntimeException("Solution :: solution() :: Can't go from S to A and B");
        
        return answer;
    }
    
    // 그래프 탐색
    // return 매개변수 start에서 출발하여 탐색 가능한 모든 노드로 가는 최소 비용 
    private int[] visitMinCost(List<List<Edge>> graph, int start) {
        int[] result = new int[graph.size()];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        
        PriorityQueue<Edge> pQueue = new PriorityQueue<>( (e1, e2) -> e1.cost - e2.cost);
        pQueue.offer(new Edge(start, 0));
        
        while (!pQueue.isEmpty()) {
            Edge poll = pQueue.poll();
            
            int node = poll.linked,
                cost = poll.cost;
            
            if (result[node] < cost) continue;
            
            for (Edge edge : graph.get(node)) {
                int nextNode = edge.linked,
                    nextCost = cost + edge.cost;
                
                if (result[nextNode] <= nextCost) continue;
                result[nextNode] = nextCost;
                
                pQueue.offer(new Edge(nextNode, nextCost));
            }
        }
        
        return result;
    }
    
    private List<List<Edge>> generateGraph(int n, int[][] infos) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        
        for (int[] info : infos) {
            graph.get(info[0]).add(new Edge(info[1], info[2]));
            graph.get(info[1]).add(new Edge(info[0], info[2]));
        }
        
        return graph;
    }
}