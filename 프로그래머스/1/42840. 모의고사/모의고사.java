import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] input = {
            {1, 2, 3, 4, 5},                // 1번 수포자 찍는 방식
            {2, 1, 2, 3, 2, 4, 2, 5},       // 2
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}  // 3
        };
        
        int[]   idx = {0, 0, 0},            // 각 수포자별 찍을 값의 인덱스
                correctCount = {0, 0, 0};   // 각 수포자별 정답 개수
        
        for (int answer : answers) {
            for (int i = 0; i < 3; i++)     // 정답 여부 확인
                if (answer == input[i][idx[i]++]) correctCount[i]++;
            
            for (int i = 0; i < 3; i++)     // 다음 인덱스 번호 넘어가면 초기번호로 수정
                if (idx[i] >= input[i].length) idx[i] = 0; 
        }
        
        int max = Math.max(Math.max(correctCount[0], correctCount[1]), correctCount[2]);
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            if (correctCount[i] == max) answerList.add(i + 1);
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}