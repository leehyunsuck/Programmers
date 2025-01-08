import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        // roads 배열을 Graph로 변경
        List<List<Integer>> locationLink = createGraphWithDoubleArray(roads, n);
        
        int[] minMoveCount = createMinMoveArray(locationLink, destination);
        
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = minMoveCount[sources[idx]];
        }
        
        return answer;
    }
    
    public int[] createMinMoveArray(List<List<Integer>> graph, int start) {
        int[] result = new int[graph.size()];
        
        for (int idx = 0; idx < result.length; idx++)
            result[idx] = -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        
        boolean[] visited = new boolean[graph.size()];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            result[poll[0]] = poll[1];
            
            int nextCount = poll[1] + 1;
            for (int next : graph.get(poll[0])) {
                if (visited[next]) continue;
                
                queue.offer(new int[] {next, nextCount});
                visited[next] = true;
            }
        }
        
        return result;
    }
    
    public List<List<Integer>> createGraphWithDoubleArray(int[][] arrays, int count) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i <= count; i++) {
            result.add(new ArrayList<>());
        }
        
        for (int[] array : arrays) {
            result.get(array[0]).add(array[1]);
            result.get(array[1]).add(array[0]);
        }
        
        return result;
    }
}

// n : 지역 개수
// roads : 지역 연결 정보
// sources : 복귀해야하는 부대원 위치
// destination : 복귀해야하는 위치


// 시간초과
/*
import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        // roads 배열을 Graph로 변경
        List<List<Integer>> locationLink = createGraphWithDoubleArray(roads, n);
        
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = getMinMoveCountBFS(locationLink, sources[idx], destination);
        }
        
        return answer;
    }
    
    public int getMinMoveCountBFS(List<List<Integer>> graph, int start, int end) {
        if (start == end) return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        
        boolean[] visited = new boolean[graph.size()];
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if (poll[0] == end)
                return poll[1];
            
            int moveCount = poll[1] + 1;
            for (int next : graph.get(poll[0])) {
                if (visited[next]) continue;
                queue.offer(new int[] {next, moveCount});
            }
        }

        return -1;
    }
    
    public List<List<Integer>> createGraphWithDoubleArray(int[][] arrays, int count) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i <= count; i++) {
            result.add(new ArrayList<>());
        }
        
        for (int[] array : arrays) {
            result.get(array[0]).add(array[1]);
            result.get(array[1]).add(array[0]);
        }
        
        return result;
    }
}
*/