import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (arr1, arr2) -> {
            int temp = arr1[1] - arr2[1];
            if (temp != 0) return temp;
            return arr1[0] - arr2[0];
        });

        int answer = 0,
            end = 0;
        
        for (int[] target : targets) {
            if (target[0] < end) continue;
            
            answer++;
            end = target[1];
        }
        
        return answer;
    }
}