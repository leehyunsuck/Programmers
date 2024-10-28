import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // 동적 배열 == 리스트 == 공간 크기를 처음에 지정하지 않아
        List<Integer> answerList = new ArrayList<>();
        
        // arr 배열 모든 값을 탐색해
        for (int num : arr)         // 원하는 조건의 값은 리스트에 넣어
            if (num % divisor == 0) answerList.add(num);
        answerList.sort(Comparator.naturalOrder());
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) 
            answer[i] = answerList.get(i);
        
        return answer.length == 0 ? new int[] {-1} : answer;
    }
}