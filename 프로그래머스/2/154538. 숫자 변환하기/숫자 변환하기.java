import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, 0});
        
        Set<Integer> used = new HashSet<>();
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();  // [0] : value , [1] : count
            
            int[] nextXs = {poll[0] + n, poll[0] * 2, poll[0] * 3};
            
            for (int nextX : nextXs) {
                if (nextX == y) return poll[1] + 1;
                if (nextX > y) continue;
                if (used.contains(nextX)) continue;
                
                used.add(nextX);
                queue.offer(new int[] {nextX, poll[1] + 1});
            }
        }
        
        return -1;
    }
}
