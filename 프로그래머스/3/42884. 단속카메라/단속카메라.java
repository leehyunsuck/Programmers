import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a1, a2) -> a1[1] - a2[1]);
        
        int answer = 1,
            nowLocation = routes[0][1];
        
        for (int[] route : routes) {
            if (nowLocation >= route[0]) continue;
            answer++;
            nowLocation = route[1];
        }
        
        return answer;
    }
}