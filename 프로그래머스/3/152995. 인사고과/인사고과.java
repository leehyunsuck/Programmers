import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        Arrays.parallelSort(scores, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a2[0] - a1[0]);
        
        int answer = 1, 
            maxColleagueScore = 0;
        for (int[] score : scores) {
            if (score[1] < maxColleagueScore) {
                if (score == wanho) return -1;
                continue;
            }
            maxColleagueScore = score[1];
            
            if (score[0] + score[1] > wanho[0] + wanho[1])
                answer++;
        }
        
        return answer;
    }
}

// 배열 길이 최대 100,000 인김에 병렬 작동하는지 테스트
// + 다른 사람 풀이에서 정렬한거 보고 삼항 연산자로 해봄