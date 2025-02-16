import java.util.*;

class Solution {
    /**
     * 클라우드 오토스케일링 횟수 파악
     *
     * @Param players[]     사용자 수
     * @Param m             증설 단위
     * @Param k             증설시 지속 시간
     * 
     * @Return 증설한 서버 개수
     */
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // { {만료시간, 증설개수}, ... }
        Queue<int[]> serverEndTimeAndCount = new LinkedList<>();
        
        int nowServer = 1;
        for (int time = 0; time < players.length; time++) {
            int player = players[time];
            
            // 서버 축소
            if (!serverEndTimeAndCount.isEmpty() && serverEndTimeAndCount.peek()[0] == time) {
                nowServer -= serverEndTimeAndCount.poll()[1];
            }
            
            // 현재 서버로 충분
            if (nowServer * m > player) continue;
            
            // 서버 증설
            int overPlayer = player - (nowServer * m - 1),
                scaleUpServer = (overPlayer / m) + (overPlayer % m == 0 ? 0 : 1);
            answer += scaleUpServer;
            nowServer += scaleUpServer;
            
            serverEndTimeAndCount.offer(new int[] {time + k, scaleUpServer});
        }
        
        return answer;
    }
}