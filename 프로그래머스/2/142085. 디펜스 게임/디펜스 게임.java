import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int e : enemy) {
            pQ.offer(e);
            n -= e;
            answer++;
            
            if (n >= 0) continue;
            if (k <= 0) {
                answer--;
                break;
            }
            
            n += pQ.poll();
            k--;
        }
        
        return answer;
    }
}