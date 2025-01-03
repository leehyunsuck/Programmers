import java.util.*;

class Solution {
    private int[][] points;
    
    class Robot {
        private int[] now;
        private int[] end;        
        private int[] route;
        private int idx;
        private int moveCount;
        
        Robot(int[] route) {
            this.now = Arrays.copyOf(points[route[0] - 1], 2);
            this.end = Arrays.copyOf(points[route[1] - 1], 2);
            this.route = route;
            this.idx = 2;
            this.moveCount = 0;
        }
        
        public boolean moveForEnd() {
            while (now[0] == end[0] && now[1] == end[1]) {
                if (idx == route.length) return true;
                end = Arrays.copyOf(points[route[idx++] - 1], 2);
            }
            
            if (now[0] != end[0]) now[0] += now[0] < end[0] ? 1 : -1;
            else now[1] += now[1] < end[1] ? 1 : -1;
            
            moveCount++;
            return false;
        }
        
        public String toKey() {
            return moveCount + ":" + now[0] + "," + now[1];
        }
    }
    

    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        
        Queue<Robot> queue = new LinkedList<>();
        resetRobotQueue(queue, routes);
        
        int answer = moveForBFS(queue);
        
        return answer;
    }
    
    public int moveForBFS(Queue<Robot> queue) {
        int result = 0;
        
        Map<String, Integer> moveMap = new HashMap<>();
        
        while (!queue.isEmpty()) {
            Robot robot = queue.poll();
            
            // 2개 이상 겹치면 충돌 횟수 증가
            String key = robot.toKey();
            int value  = moveMap.getOrDefault(key, 0);
            
            if (value == 1)
                result++;
            
            moveMap.put(key, value + 1);
            
            if (!robot.moveForEnd()) queue.offer(robot); 
        }
        
        return result;
    }
    
    public void resetRobotQueue(Queue<Robot> queue, int[][] routes) {
        for (int[] route : routes) {
            queue.offer(new Robot(route));
        }
    }
}
