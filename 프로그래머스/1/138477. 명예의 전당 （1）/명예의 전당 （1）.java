import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        Queue<Integer> pQ = new PriorityQueue();
        for (int i = 0; i < score.length; i++) {
            pQ.add(score[i]);
            if (pQ.size() > k) pQ.poll();
            answer[i] = pQ.peek();
        }
        
        return answer;
    }
}