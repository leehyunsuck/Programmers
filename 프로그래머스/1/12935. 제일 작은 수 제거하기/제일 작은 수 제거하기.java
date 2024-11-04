import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int minIdx = 0;
        
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[minIdx] > arr[idx]) minIdx = idx;
        }
        
        int[] answer = new int[arr.length - 1];
        if (answer.length == 0) return new int[] {-1};
        
        int answerIdx = 0;
        for (int arrIdx = 0; arrIdx < arr.length; arrIdx++) {
            if (minIdx == arrIdx) continue;
            answer[answerIdx++] = arr[arrIdx];
        }
        
        return answer;
    }
}
