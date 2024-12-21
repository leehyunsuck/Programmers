import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Queue<Integer> aQueue = new PriorityQueue<>(Collections.reverseOrder()),
                       bQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int idx = 0; idx < A.length; idx++) {
            aQueue.offer(A[idx]);
            bQueue.offer(B[idx]);
        }
        
        int answer = 0;
        while (!aQueue.isEmpty()) {
            int aNum = aQueue.poll(),
                bNum = bQueue.peek();
            
            if (bNum > aNum) {
                answer++;
                bQueue.poll();
            }
        }
        
        return answer;
    }
}