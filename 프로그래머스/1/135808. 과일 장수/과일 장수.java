import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Queue<Integer> pQ = new PriorityQueue(Collections.reverseOrder());
        for (int s : score) pQ.add(s);
        
        while (pQ.size() >= m) {
            int minScore = k;
            
            for (int i = 0; i < m; i++) {
                int getScore = pQ.poll();
                if (getScore < minScore) minScore = getScore;
            }
            answer += minScore * m;
        }
        
        return answer;
    }
}

/*
가장 높은 점수의 사과들을 m개씩 모아서 이익 계산
이익 계산 : 최저 사과 점수 * m
*/