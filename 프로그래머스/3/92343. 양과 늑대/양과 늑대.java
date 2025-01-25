import java.util.*;

class Solution {
    private class Info {
        boolean[] used;
        int wolf, sheap, nowIdx;
        
        Info(boolean[] used, int wolf, int sheap, int nowIdx) {
            this.used = used;
            this.wolf = wolf;
            this.sheap = sheap;
            this.nowIdx = nowIdx;
        }
        
        Info copy() {
            return new Info(this.used.clone(), this.wolf, this.sheap, this.nowIdx);
        }
        
        String getString() {
            StringBuilder builder = new StringBuilder();
            builder.append(nowIdx).append(",").append(wolf).append(",").append(sheap).append(",");
            for (boolean b : used)
                builder.append(b ? "1" : "0");
            return builder.toString();
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        int len = info.length;
        
        List<List<Integer>> graph = createGraph(edges, len);
        
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(new boolean[len], 0, 0, 0));
        
        Set<String> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            
            if (!poll.used[poll.nowIdx]) {
                if (info[poll.nowIdx] == 0) poll.sheap++;
                else poll.wolf++;
                poll.used[poll.nowIdx] = true;
            }
            
            if (poll.wolf >= poll.sheap) continue;
            if (visited.contains(poll.getString())) continue;
            
            visited.add(poll.getString());
            answer = Math.max(answer, poll.sheap);
 
            for (int idx : graph.get(poll.nowIdx)) {
                Info copy = poll.copy();
                copy.nowIdx = idx;
                queue.offer(copy);
            }
        }
        
        return answer;
    }
    
    private List<List<Integer>> createGraph(int[][] edges, int len) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0],
                child  = edges[i][1];
            
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        
        return graph;
    }
}

// 양을 모아
// 방문하면 해당 노드의 동물은 나를 따라와
// 늑대가 양보다 많으면 잡아먹혀

// 왔던칸 지나갈수는 있음

// info[] 0 == 양, 1 == 늑대
// edges[][] 연결정보