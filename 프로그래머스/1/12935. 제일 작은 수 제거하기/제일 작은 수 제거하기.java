import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int minIdx = 0;
        
        List<Integer> answer = new ArrayList<>();
        for (int idx = 0; idx < arr.length; idx++) {
            answer.add(arr[idx]);
            if (arr[idx] < arr[minIdx]) minIdx = idx;
        }
        answer.remove(minIdx);
        
        return answer.size() == 0 ? new int[] {-1} : answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
