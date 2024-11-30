import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (arr1, arr2) -> arr1[1] - arr2[1]);
        
        int answer = 0,
            tempMax = 0;
        
        for (int[] target : targets) {
            if (target[0] >= tempMax) {
                answer++;
                tempMax = target[1];
            }
        }
        
        return answer;
    }
}