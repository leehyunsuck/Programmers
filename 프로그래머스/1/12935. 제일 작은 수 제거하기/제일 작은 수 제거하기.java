import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int minIdx = 0;
        
        List<Integer> answerList = new ArrayList<>();
        for (int idx = 0; idx < arr.length; idx++) {
            answerList.add(arr[idx]);
            if (arr[idx] < arr[minIdx]) minIdx = idx;
        }
        answerList.remove(minIdx);
        
        if (answerList.size() == 0) return new int[] {-1};
        
        int[] answer = new int[answerList.size()];
        for (int idx = 0; idx < answerList.size(); idx++) 
            answer[idx] = answerList.get(idx);
        
        return answer;
    }
}
