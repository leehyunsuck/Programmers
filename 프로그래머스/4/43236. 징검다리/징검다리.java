import java.util.*;

class Solution {
    /**
     * @Param distance  도착지점 까지의 거리
     * @Param rocks[]   바위들 위치
     * @Param n         제거할 바위 수
     *
     * @Return          제거한 뒤 각 지점 사이 거리의 최소값 중 가장 큰 값
     *
     * 부연설명
     * [2, 11, 14, 17, 21] 에서 [2, 14]를 제거하면?
     * -> [0(출발지), 11, 17, 21, 25(도착지)]
     * -> 사이 거리는 [11, 6, 4, 4] 
     */
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int minLen = 1,
            maxLen = distance;
        while (minLen <= maxLen) {
            int midLen = (minLen + maxLen) / 2;
            
            int remove = 0,
                lastLocation = 0;
            
            for (int rockLocation : rocks) {
                if (rockLocation - lastLocation < midLen) remove++;
                else lastLocation = rockLocation;
            }
            if (distance - lastLocation < midLen) remove++;
            
            if (remove > n) maxLen = midLen - 1;
            else {
                // if (remove == n) answer = midLen;
                // minLen = midLen + 1;
                answer = midLen;
                minLen = midLen + 1;
            }
        }
        
        return answer;
    }
}
