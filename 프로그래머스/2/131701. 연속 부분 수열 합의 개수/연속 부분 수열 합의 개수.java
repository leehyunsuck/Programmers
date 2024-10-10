import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answerSet = new HashSet<>();
        
        int arrayLen = elements.length;
        for (int count = 1; count <= elements.length; count++) {        // 1개 ~ 전체개수
            for (int startIdx = 0; startIdx < arrayLen; startIdx++) {   // 0번 인덱스부터 개수만큼 더하기
                int sum = 0;
                
                for (int idx = startIdx; idx < startIdx + count; idx++) // 더하기
                    sum += elements[idx % arrayLen];                    // idx가 배열보다 크면 앞부분 더하면 됨
                
                answerSet.add(sum);
            }
        }
        
        return answerSet.size();
    }
}