import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int e : enemy) {
            pQ.offer(e);
            n -= e;
            
            if (n < 0) {
                if (k <= 0) break;
                k--;
                n += pQ.poll();
            }
            
            answer++;
        }
        
        return answer;
    }
}