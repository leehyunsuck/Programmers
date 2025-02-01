import java.util.*;

class Solution {
    /**                     (1-base)       
     * @Param n             노드 개수
     * @Param path[][]      노드 정보      [0],[1] 노드연결정보 / [2] 걸리는 시간
     * @Param gates[]       출입구 노드
     * @Param submmits[]    산봉우리 노드
     *
     * intensity : 휴식 없이 이동하는 시간
     *
     * @Return intensity가 가장 짧은 코스의 [산봉우리 번호, intensity]
     * 조건에 맞는게 여러개면 산봉우리 번호 작은것
     */
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // [ [연결된 노드, 이동시간], ... ]
        List<List<int[]>> graph = generateGraph(n, paths);
        
        // HashSet - contains 용도 -> O(1) 이라서
        Set<Integer> gateNodes = arrToSet(gates),
                     topNodes  = arrToSet(summits);
        
        // [ [산봉우리 번호, intensity], ... ]
        PriorityQueue<int[]> pQueue = new PriorityQueue<>( (arr1, arr2) -> {
            int compareIntensity = arr1[1] - arr2[1];
            return compareIntensity == 0 ? arr1[0] - arr2[0] : compareIntensity;
        });
        addPQueueBFS(pQueue, graph, gateNodes, topNodes);
        
        return pQueue.poll();
    }
    
    private void addPQueueBFS(PriorityQueue<int[]> pQueue, List<List<int[]>> graph,
                              Set<Integer> gateNodes, Set<Integer> topNodes) {
        // [ [node, intensity], ... ]
        PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> {
            int intensityCompare = arr1[1] - arr2[1];
            return intensityCompare == 0 ? arr1[0] - arr2[0] : intensityCompare;
        });

        int[] minIntensity = new int[graph.size()];
        Arrays.fill(minIntensity, Integer.MAX_VALUE);

        for (int gateNode : gateNodes) {
            queue.offer(new int[]{gateNode, 0});
            minIntensity[gateNode] = 0;
        }

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int node = info[0],
                intensity = info[1];

            if (intensity > minIntensity[node]) continue;
            
            if (topNodes.contains(node)) {
                pQueue.add(new int[]{node, intensity});
                continue;
            }

            for (int[] nextInfo : graph.get(node)) {
                int nextNode = nextInfo[0], 
                    time = nextInfo[1];
                int nextIntensity = Math.max(intensity, time);
                
                if (gateNodes.contains(nextNode)) continue;
                if (nextIntensity >= minIntensity[nextNode]) continue;
                
                minIntensity[nextNode] = nextIntensity;
                queue.offer(new int[]{nextNode, nextIntensity});
            }
        }
    }
    
    private Set<Integer> arrToSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        if (arr != null) {
            for (int value : arr)
                set.add(value);
        }
        return set;
    }
    
    private List<List<int[]>> generateGraph(int n, int[][] paths) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int node = 0; node <= n; node++)
            graph.add(new ArrayList<>());

        for (int[] path : paths) {
            graph.get(path[0]).add(new int[] {path[1], path[2]});
            graph.get(path[1]).add(new int[] {path[0], path[2]});
        }
        
        return graph;
    }
}

/* 일부분 시간초과
어짜피 Move class의 필드는 int형이니까 배열로 바꿔보면서 필요 없던 부분 지워보기

import java.util.*;

class Solution {
    private class Move {
        int gateNode, topNode, beforeNode, nowNode, intensity;
        
        Move(int gateNode) {
            this.gateNode = gateNode;
            this.nowNode  = gateNode;
        }
        
        boolean isEnd() {
            return topNode != 0 && nowNode == gateNode;
        }
        
        int[] getEndInfo() {
            return new int[] {topNode, intensity};
        }

        Move clone(int[] info) {
            Move move = new Move(this.gateNode);    // 출발지 복사
            move.topNode = this.topNode;            // 정상 복사
            move.beforeNode = this.nowNode;         // 이전 노드는 바뀌기 전 값
            move.nowNode = info[0];                 // 현재 노드는 바뀐값
            move.intensity = Math.max(this.intensity, info[1]);   // (무)휴식 가장 긴 시간으로 설정
            return move;
        }
        
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(topNode).append(":")
                    .append(beforeNode).append(":")
                    .append(nowNode).append(":")
                    .append(intensity);
            return builder.toString();
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // [ [연결된 노드, 이동시간], ... ]
        List<List<int[]>> graph = generateGraph(n, paths);
        
        Set<Integer> gateNodes = arrToSet(gates),
                     topNodes  = arrToSet(summits);
        
        PriorityQueue<int[]> pQueue = new PriorityQueue<>( (arr1, arr2) -> {
            int compareIntensity = arr1[1] - arr2[1];
            return compareIntensity == 0 ? arr1[0] - arr2[0] : compareIntensity;
        });
        addPQueueBFS(pQueue, graph, gateNodes, topNodes);
        
        return pQueue.poll();
    }
    
    private void addPQueueBFS(PriorityQueue<int[]> pQueue, List<List<int[]>> graph,
                              Set<Integer> gateNodes, Set<Integer> topNodes) {
        PriorityQueue<Move> queue = new PriorityQueue<>( (move1, move2) -> move1.intensity - move2.intensity );
        for (int gateNode : gateNodes) {
            queue.offer(new Move(gateNode));
            
            // 방문 여부는 출발지가 다르므로 gateNode 반복문마다 초기회
            Set<String> visited = new HashSet<>();
            visited.add(queue.peek().toString());
            
            // (무)휴식 최대 이동 거리값들 중 구한 최소값 있으면 그걸로 설정
            int intensity = pQueue.isEmpty() ? Integer.MAX_VALUE : pQueue.peek()[1];
            while (!queue.isEmpty()) {
                Move move = queue.poll();
                
                if (move.intensity > intensity) continue;
                if (move.isEnd()) {
                    intensity = move.intensity;
                    pQueue.add(move.getEndInfo());
                    continue;
                }
                
                for (int[] nextInfo : graph.get(move.nowNode)) {
                    if (nextInfo[1] > intensity) continue;
                    if (gateNodes.contains(nextInfo[0]) && (move.gateNode != nextInfo[0] || move.topNode == 0)) continue;
                    if (topNodes.contains(nextInfo[0]) && move.topNode != 0) continue;
                    Move clone = move.clone(nextInfo);
                    
                    if (topNodes.contains(clone.nowNode)) clone.topNode = clone.nowNode;
                    if (visited.contains(clone.toString())) continue;
                    visited.add(clone.toString());
                    
                    queue.offer(clone);
                }
            }
        }
    }
    
    private Set<Integer> arrToSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        if (arr != null) {
            for (int value : arr)
                set.add(value);
        }
        return set;
    }
    
    private List<List<int[]>> generateGraph(int n, int[][] paths) {
        List<List<int[]>> graph = new ArrayList<>();
        
        // 노드 생성
        for (int node = 0; node <= n; node++)
            graph.add(new ArrayList<>());
        // 노드 연결
        for (int[] path : paths) {
            graph.get(path[0]).add(new int[] {path[1], path[2]});
            graph.get(path[1]).add(new int[] {path[0], path[2]});
        }
        
        return graph;
    }
}
*/
