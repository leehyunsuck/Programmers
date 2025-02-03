import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Arrays.sort(summits);
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) 
            graph.add(new ArrayList<>());
        for (int[] path : paths) {
            graph.get(path[0]).add(new int[] {path[1], path[2]});
            graph.get(path[1]).add(new int[] {path[0], path[2]});
        }
        
        Set<Integer> endSet = new HashSet<>();
        for (int end : summits)
            endSet.add(end);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>( (arr1, arr2) -> {
            int intensityCompare = arr1[1] - arr2[1];
            return intensityCompare == 0 ? arr1[0] - arr2[0] : intensityCompare;
        });
        
        int[] minIntensity = new int[n + 1];
        Arrays.fill(minIntensity, Integer.MAX_VALUE);
        for (int gate : gates) {
            queue.offer(new int[] {gate, 0});
            minIntensity[gate] = 0;
        }
        
        int[] answer = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (endSet.contains(poll[0])) {
                if (poll[1] < answer[1] || (poll[1] == answer[1] && poll[0] < answer[0])) answer = poll;
                continue;
            }
            
            if (poll[1] > answer[1]) break;
                
            for (int[] nextInfo : graph.get(poll[0])) {
                int intensity = Math.max(nextInfo[1], poll[1]);
                
                if (minIntensity[nextInfo[0]] > intensity) {
                    minIntensity[nextInfo[0]] = intensity;
                    queue.offer(new int[] {nextInfo[0], intensity});
                }
                
            }
        }
        
        return answer;
    }
}